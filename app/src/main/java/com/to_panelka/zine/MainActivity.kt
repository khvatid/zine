package com.to_panelka.zine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.to_panelka.zine.navigation.ZineNavHost
import com.to_panelka.zine.navigation.ZineScreen
import com.to_panelka.zine.ui.composable.ZineBottomBar
import com.to_panelka.zine.ui.theme.ZineTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZineTheme {
                val screens : List<ZineScreen> = ZineScreen.values().toList()
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentScreen = ZineScreen.fromRoute(backStackEntry.value?.destination?.route)

                Scaffold(
                    bottomBar = { ZineBottomBar(
                        allScreen = screens,
                        onBottomSelected = { screen ->
                            navController.navigate(screen.name){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        currentScreen = currentScreen
                    ) }
                ){
                    ZineNavHost(
                        modifier = Modifier.padding(it),
                        navController = navController)
                }
            }
        }
    }
}

