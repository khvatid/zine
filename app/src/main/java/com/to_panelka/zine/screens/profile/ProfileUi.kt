package com.to_panelka.zine.screens.profile


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUI() {
    Column {
            Card(onClick = { /*TODO*/ }) {
              Text(text = "Пользователь")
            }
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Профиль")
    }

}


@Composable
@Preview
private fun Preview(){
    ProfileUI()
}