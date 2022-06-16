package com.to_panelka.zine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.to_panelka.zine.navigation.NavigationHost
import com.to_panelka.zine.ui.composable.other.BottomNavigationBar
import com.to_panelka.zine.ui.theme.ZineTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZineTheme {
                val navController = rememberNavController()
                Scaffold(
                    content = { it ->
                        Box(modifier = Modifier.padding(it)) {
                            NavigationHost(navController = navController)
                        }
                    },
                    bottomBar = { BottomNavigationBar(navController = navController) }
                )
            }
        }
    }
}

