package com.to_panelka.zine.screens.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.to_panelka.zine.ui.composable.WheelPicker


@Composable
fun ScheduleUi(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        WheelPicker()
    }
}