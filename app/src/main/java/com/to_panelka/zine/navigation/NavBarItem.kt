package com.to_panelka.zine.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector


enum class ZineScreen(
    val icon: ImageVector
){
    Students(
        icon = Icons.Filled.List
    ),
    Schedule(
        icon = Icons.Filled.Home
    ),
    Profile(
        icon = Icons.Filled.Person
    );
    companion object{
        fun fromRoute(route: String?): ZineScreen =
            when(route?.substringBefore("/")){
                Students.name -> Students
                Schedule.name -> Schedule
                Profile.name -> Profile
                null -> Schedule
                else -> Schedule
            }
    }
}

