package com.to_panelka.zine.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner

import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.to_panelka.zine.navigation.ZineScreen.*

import com.to_panelka.zine.screens.profile.ProfileUI
import com.to_panelka.zine.screens.schedule.ScheduleUi

import com.to_panelka.zine.screens.students.StudentsUi


/*sealed class BottomNavRoutes(val route: String) {
    object Students : BottomNavRoutes("students")
    object Schedule : BottomNavRoutes("schedule")
    object Profile : BottomNavRoutes("profile")
}*/

/*sealed class GlobalNavRoutes(val route: String) {
    object Add : GlobalNavRoutes("add")
}*/




@Composable
fun ZineNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val owner = LocalViewModelStoreOwner.current
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Schedule.name,
    ) {
        navigation(startDestination = "${Students.name}/list", route = Students.name) {
            composable(route = "${Students.name}/list") { StudentsUi() }
            composable(route = "${Students.name}/{user}",
                arguments = listOf(navArgument("user") {
                    type = NavType.StringType
                })
            ) {}
            composable(route = "create") {}
        }

        navigation(startDestination = "${Schedule.name}/current", route = Schedule.name) {
            composable(route = "${Schedule.name}/current") { ScheduleUi() }
            composable(route = "${Schedule.name}/{lesson}",
                arguments = listOf(navArgument("lesson") {
                    type = NavType.StringType
                })
            ) {}
            composable(route = "next") {}
            composable(route = "prev") {}
        }

        navigation(startDestination = "${Profile.name}/menu", route = Profile.name) {
            composable(route = "${Profile.name}/menu") { ProfileUI() }
            composable(route = "${Profile.name}/edit") {}
        }


        //deprecated
        /*composable(BottomNavRoutes.Students.route) {
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
        composable(BottomNavRoutes.Profile.route) { ProfileUI() }*/
    }
}

/*private fun navigateToSingleStudent(
    navController: NavController,
    studentName: String
) {
    navController.navigate("${BottomNavRoutes.Students.route}/$studentName")
}*/