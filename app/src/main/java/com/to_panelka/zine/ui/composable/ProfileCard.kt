package com.to_panelka.zine.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.to_panelka.zine.R
import com.to_panelka.zine.repository.models.Profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCard(profile: Profile){
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(profile.imageURL)
                .crossfade(true)
                .build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .size(64.dp))
            Text(
                text = profile.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp))
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun ProfileCardPrev(){
    val profile = Profile("Dmitry",
        "https://sun9-81.userapi.com/s/v1/ig2/NIGNXPHPpnlkwP9PE2GXubdHCuZxBOf7IsZXPfmBI_vtfFlYxiIk4NhASf4ldWAHzrSqcrqrAM9AJcgufE3Ihev8.jpg?size=2560x1920&quality=96&type=album"
    )
    Column() {
        ProfileCard(profile = profile)
        Text(text = "empty")
    }

}