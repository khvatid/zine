package com.to_panelka.zine.ui.composable


import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.to_panelka.zine.navigation.ZineScreen

@Composable
fun ZineBottomBar(
    allScreen: List<ZineScreen>,
    onBottomSelected: (ZineScreen) -> Unit,
    currentScreen : ZineScreen
    ) {
        BottomAppBar() {
            allScreen.forEach{
                NavigationBarItem(
                    selected = currentScreen == it,
                    onClick = { onBottomSelected(it) },
                    icon = {Icon(it.icon,null)},
                    label = {Text(it.name)}
                )
            }
        }
}