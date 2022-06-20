package com.to_panelka.zine.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.to_panelka.zine.repository.entities.StudentEntity
import com.to_panelka.zine.screens.profile.ProfileUI
import com.to_panelka.zine.screens.schedule.ScheduleUi
import com.to_panelka.zine.screens.students.SingleStudentScreen
import com.to_panelka.zine.screens.students.AddStudentScreen
import com.to_panelka.zine.screens.students.StudentsScreen
import com.to_panelka.zine.viewModels.StudentsViewModel
import com.to_panelka.zine.viewModels.factory.StudentsViewModelFactory


sealed class BottomNavRoutes(val route: String) {
    object Students : BottomNavRoutes("students")
    object Schedule : BottomNavRoutes("schedule")
    object Profile : BottomNavRoutes("profile")
}

sealed class GlobalNavRoutes(val route: String) {
    object Add : GlobalNavRoutes("add")
}


@Composable
fun ZineNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val owner = LocalViewModelStoreOwner.current
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavRoutes.Schedule.route,
    ) {

        composable(BottomNavRoutes.Students.route) {
            owner?.let {
                val viewModel: StudentsViewModel = viewModel(
                    it,
                    "StudentViewModel",
                    StudentsViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                StudentsScreen(
                    viewModel = viewModel,
                    onStudentClick = { name ->
                        navigateToSingleStudent(
                            navController,
                            name
                        )
                    },
                    onAddClick = {navController.navigate("${BottomNavRoutes.Students.route}/${GlobalNavRoutes.Add.route}")}
                )
            }
        }
        composable(
            route = "${BottomNavRoutes.Students.route}/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            val studName = it.arguments?.getString("name")
            owner?.let {
                val viewModel: StudentsViewModel = viewModel(
                    it,
                    "StudentViewModel",
                    StudentsViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                viewModel.findStudent(studName.toString())
                SingleStudentScreen(student = studName.toString()) {
                    viewModel.deleteStudent(studName.toString())
                    navController.popBackStack()
                }
            }
        }
        composable("${BottomNavRoutes.Students.route}/${GlobalNavRoutes.Add.route}") {
            owner?.let {
                val viewModel: StudentsViewModel = viewModel(
                    it,
                    "StudentViewModel",
                    StudentsViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                AddStudentScreen(
                    onAddClick = { name ->
                        viewModel.insertStudent(StudentEntity(name))
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(BottomNavRoutes.Schedule.route) { ScheduleUi() }
        composable(BottomNavRoutes.Profile.route) { ProfileUI() }
    }
}

private fun navigateToSingleStudent(
    navController: NavController,
    studentName: String
) {
    navController.navigate("${BottomNavRoutes.Students.route}/$studentName")
}