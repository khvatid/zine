package com.to_panelka.zine.ui.composable.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.to_panelka.zine.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProfile(){
    Card() {
        Row() {
            Column() {
                Text(text = "Имя Фамилия")
                Text(text = "Почта")
            }
            Column() {
                AsyncImage(
                    model = "https://example.com/image.jpg",
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground))
            }
        }
    }
}

@Composable
@Preview
private fun PrevCard(){
    CardProfile()
}