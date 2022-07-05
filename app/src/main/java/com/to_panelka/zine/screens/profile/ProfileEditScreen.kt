package com.to_panelka.zine.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.to_panelka.zine.R
import com.to_panelka.zine.database.entities.ProfileEntity
import com.to_panelka.zine.viewModels.ProfileViewModel


@Composable
fun ProfileEditScreen(
    viewModel: ProfileViewModel
) {
    val profile by viewModel.profile.observeAsState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            viewModel.updateProfile(
                profile = ProfileEntity(
                    fullName = profile!!.fullName,
                    photo = uri.toString()
                )
            )
        }
    )

    Column() {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(profile!!.photo)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
        )
        Text(text = profile!!.photo!!)
        Button(onClick = { launcher.launch("image/*")}) {
            Text(text = "Добавить фото")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile Edit")
    }


}