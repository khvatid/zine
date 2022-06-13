package com.to_panelka.zine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.to_panelka.zine.components.RootComponent
import com.to_panelka.zine.repository.models.Profile
import com.to_panelka.zine.ui.composable.ProfileCard
import com.to_panelka.zine.ui.theme.ZineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lifecycle = LifecycleRegistry()
        val root = RootComponent(DefaultComponentContext(lifecycle))
        setContent {
            ZineTheme {
                RootUI(component = root)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalDecomposeApi::class)
@Composable
fun RootUI(component: RootComponent) {

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ) {
            component.screens.forEach {
                NavigationBarItem(
                    selected = component.currentScreen.value == it.label,
                    onClick = {
                        component.onClickBar(it.label)
                    },
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(
                            text = it.label,
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                )
            }
        }
    }) { it ->
        Children(
            routerState = component.routerState,
            modifier = Modifier.padding(it)
        ) { child ->
            child.instance()
        }

    }


}
