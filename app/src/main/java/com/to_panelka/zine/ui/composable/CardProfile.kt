package com.to_panelka.zine.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.to_panelka.zine.R
import com.to_panelka.zine.ui.theme.ZineTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProfile() {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(3.0f)
            ) {
                Text(
                    text = "Зырина Алина",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
                Text(
                    text = "Почта",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 0.dp)
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://sun9-11.userapi.com/s/v1/ig2/dDF9clyh8LhRm1IqfyzNU_F69jNnqFxHevLrLuR2Y9bFZ8k_4tT1-RpBW4XYTpEbzChNho3r1pjxtJ-3_SUtoU8-.jpg?size=908x1018&quality=96&type=album",
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .size(100.dp)
                )
                ElevatedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Edit")
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,

)
private fun PrevCard() {
    ZineTheme(darkTheme = true) {
        CardProfile()
    }
}