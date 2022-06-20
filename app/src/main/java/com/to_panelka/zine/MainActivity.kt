package com.to_panelka.zine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.to_panelka.zine.navigation.ZineNavHost
import com.to_panelka.zine.ui.composable.ZineBottomNavBar
import com.to_panelka.zine.ui.theme.ZineTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZineTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { ZineBottomNavBar(navController = navController) }
                ){
                    ZineNavHost(
                        modifier = Modifier.padding(it),
                        navController = navController)
                }
            }
        }
    }
}

