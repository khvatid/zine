package com.to_panelka.zine.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screens(
    val label: String,
    val icon: ImageVector
) {
    Students(
        label = "Students",
        icon = Icons.Default.List
    ),
    Schedule(
        label = "Schedule",
        icon = Icons.Default.Home
    ),
    Profile(
        label = "Profile",
        icon = Icons.Default.Face
    )
}