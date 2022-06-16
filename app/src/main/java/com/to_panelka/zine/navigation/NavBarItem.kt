package com.to_panelka.zine.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector


data class BarItem(
    val title: String,
    val imageVector: ImageVector,
    val route: String
)

object NavBarItems{
    val barItems: List<BarItem> = listOf(
        BarItem(
            title = "Students",
            imageVector = Icons.Default.List,
            route = "students"
        ),
        BarItem(
            title = "Schedule",
            imageVector = Icons.Default.Home,
            route = "schedule"
        ),
        BarItem(
            title = "Profile",
            imageVector = Icons.Default.Person,
            route = "profile"
        )
    )
}