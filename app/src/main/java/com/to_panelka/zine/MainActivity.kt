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
import com.to_panelka.zine.repository.models.Profile
import com.to_panelka.zine.ui.composable.ProfileCard
import com.to_panelka.zine.ui.theme.ZineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZineTheme {
                val profile = Profile("Dmitry",
                    "https://sun9-81.userapi.com/s/v1/ig2/NIGNXPHPpnlkwP9PE2GXubdHCuZxBOf7IsZXPfmBI_vtfFlYxiIk4NhASf4ldWAHzrSqcrqrAM9AJcgufE3Ihev8.jpg?size=2560x1920&quality=96&type=album"
                )
                ProfileCard(profile = profile)
            }
        }
    }
}
