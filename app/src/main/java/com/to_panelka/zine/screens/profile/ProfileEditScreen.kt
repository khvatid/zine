package com.to_panelka.zine.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.to_panelka.zine.viewModels.ProfileViewModel


@Composable
fun ProfileEditScreen(
    viewModel: ProfileViewModel
) {
    
    
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Text(text = "Profile Edit")
    }
    
    
}