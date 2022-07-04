package com.to_panelka.zine.screens.profile


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun ProfileUI() {
    Column {
        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
            Text(text = "Профиль")
        }

    }
}
