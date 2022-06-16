package com.to_panelka.zine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.to_panelka.zine.ui.composable.profile.ProfileUI
import com.to_panelka.zine.ui.composable.schedule.ScheduleUi
import com.to_panelka.zine.ui.composable.students.StudentsUi


sealed class NavRoutes(val route: String){
    object Students: NavRoutes("students")
    object Schedule: NavRoutes("schedule")
    object Profile: NavRoutes("profile")
}

@Composable
fun NavigationHost(navController:NavHostController){
    NavHost(navController = navController,
        startDestination = NavRoutes.Schedule.route,
    ){
        composable(NavRoutes.Students.route){ StudentsUi()}
        composable(NavRoutes.Schedule.route){ ScheduleUi()}
        composable(NavRoutes.Profile.route){ ProfileUI()}
    }
}