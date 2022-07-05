package com.to_panelka.zine.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.to_panelka.zine.navigation.ZineScreen.*
import com.to_panelka.zine.database.entities.StudentEntity
import com.to_panelka.zine.screens.profile.ProfileEditScreen

import com.to_panelka.zine.screens.profile.ProfileUI
import com.to_panelka.zine.screens.schedule.ScheduleUi
import com.to_panelka.zine.screens.students.CreateStudentScreen
import com.to_panelka.zine.screens.students.SingleStudentScreen

import com.to_panelka.zine.screens.students.StudentsScreen
import com.to_panelka.zine.viewModels.StudentsViewModel
import com.to_panelka.zine.viewModels.factory.ProfileViewModelFactory
import com.to_panelka.zine.viewModels.factory.StudentsViewModelFactory


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
    val application = LocalContext.current.applicationContext as Application

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Schedule.name,
    ) {
        navigation(
            startDestination = "${Students.name}/list", route = Students.name
        ) {

            composable(route = "${Students.name}/list") {
                StudentsScreen(
                    viewModel = viewModel(
                        viewModelStoreOwner = owner!!,
                        key = "StudentViewModel",
                        factory = StudentsViewModelFactory(application)
                    ),
                    onAddClick = { navController.navigate("${Students.name}/create") },
                    onStudentClick = { name ->
                        navigateToSingleStudent(
                            navController = navController,
                            studentName = name
                        )
                    }
                )
            }

            //SINGLE STUDENT
            composable(
                route = "${Students.name}/{user}",
                arguments = listOf(navArgument("user") {
                    type = NavType.StringType
                }),
            ) {
                val name = it.arguments?.getString("user")
                owner?.let { vmsOwner ->
                    val viewModel: StudentsViewModel = viewModel(
                        vmsOwner,
                        "StudentViewModel",
                        StudentsViewModelFactory(application)
                    )
                    viewModel.findStudent(name.toString())
                    SingleStudentScreen(
                        student = name.toString(),
                        onDeleteClick = {
                            viewModel.deleteStudent(name.toString())
                            navController.popBackStack()
                        },
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }

            //CREATE STUDENT
            composable(route = "${Students.name}/create") {
                owner?.let {
                    val viewModel: StudentsViewModel = viewModel(
                        it,
                        "StudentViewModel",
                        StudentsViewModelFactory(application)
                    )
                    CreateStudentScreen(
                        onCreateClick = { name ->
                            viewModel.insertStudent(StudentEntity(name))
                            navController.popBackStack()
                        },
                        onBackClick = {navController.popBackStack()}
                    )
                }
            }
        }





        navigation(startDestination = "${Schedule.name}/current", route = Schedule.name) {
            composable(route = "${Schedule.name}/current") { ScheduleUi() }
            composable(
                route = "${Schedule.name}/{lesson}",
                arguments = listOf(navArgument("lesson") {
                    type = NavType.StringType
                })
            ) {}
            composable(route = "next") {}
            composable(route = "prev") {}
        }

        navigation(startDestination = "${Profile.name}/menu", route = Profile.name) {
            composable(route = "${Profile.name}/menu") {
                ProfileUI(
                    viewModel = viewModel(
                        viewModelStoreOwner = owner!!,
                        key = "ProfileViewModel",
                        factory = ProfileViewModelFactory(application)
                    ),
                    onEditClick = {navController.navigate("${Profile.name}/edit")}
                ) }
            composable(route = "${Profile.name}/edit") {
                ProfileEditScreen(
                    viewModel = viewModel(
                        viewModelStoreOwner = owner!!,
                        key = "ProfileViewModel",
                        factory = ProfileViewModelFactory(application)
                    )
                )
            }
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


private fun navigateToSingleStudent(
    navController: NavController,
    studentName: String
) {
    navController.navigate("${Students.name}/$studentName")
}
