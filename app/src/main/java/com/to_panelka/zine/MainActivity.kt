package com.to_panelka.zine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.DefaultComponentContext
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

            }
        }
    }
}
