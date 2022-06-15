package com.to_panelka.zine.ui.composable.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.to_panelka.zine.components.ProfileComponent
import com.to_panelka.zine.ui.composable.other.ItemListMenu

@Composable
fun ProfileUI(component: ProfileComponent){
    Column {
        CardProfile()
        component.listSettings.forEach {
            ItemListMenu(it)
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}