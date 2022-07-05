package com.to_panelka.zine.screens.profile


import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.to_panelka.zine.viewModels.ProfileViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUI(
    viewModel: ProfileViewModel,
    onEditClick : ()->Unit = {}) {

    val profile by viewModel.profile.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (profile == null) {
            Button(onClick = { viewModel.createProfile() }) {
                Text("Создать профиль")
            }
        } else {
            Card{
                Row() {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("content://com.android.providers.media.documents/document/image%3A75839")
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "you photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = profile!!.fullName)
                }
                Button(onClick = onEditClick) {
                    Text(text = "Edit")
                }

            }
        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Профиль")
    }

}


@Composable
@Preview
private fun Preview() {
    ProfileUI(viewModel = ProfileViewModel(LocalContext.current.applicationContext as Application))
}