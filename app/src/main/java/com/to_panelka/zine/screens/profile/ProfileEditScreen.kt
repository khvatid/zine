package com.to_panelka.zine.screens.profile

import android.content.Context.MODE_PRIVATE
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.to_panelka.zine.R
import com.to_panelka.zine.database.entities.ProfileEntity
import com.to_panelka.zine.ui.animation.LoadingAnimation
import com.to_panelka.zine.viewModels.ProfileViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File


@Composable
fun ProfileEditScreen(
    viewModel: ProfileViewModel,
    onBackClick: ()->Unit = {}
) {

    val profile by viewModel.profile.observeAsState()
    var name by remember {
        mutableStateOf(profile!!.name)
    }
    var surname by remember {
        mutableStateOf(profile!!.surname)
    }

    var showWaitDialog by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            try {
                showWaitDialog = true
                if (uri == null) throw NullPointerException()
                CoroutineScope(Dispatchers.IO).launch {
                    val photoIn = context.contentResolver.openInputStream(uri)
                    context.openFileOutput("profilePhoto.jpeg", MODE_PRIVATE).use {
                        var byte: Int
                        while ((photoIn!!.read().also { readByte ->
                                byte = readByte
                            }) != -1) {
                            it.write(byte)
                        }
                    }
                    photoIn!!.close()
                    viewModel.updateProfile(
                        profileUp = ProfileEntity(
                            id = profile!!.id,
                            name = profile!!.name,
                            surname = profile!!.name,
                            photo = File(context.filesDir, "profilePhoto.jpeg").path
                        )
                    )
                    showWaitDialog = false
                }
            } catch (e: NullPointerException) {
                showWaitDialog = false
                Toast(context).let {
                    it.setText("Cancel")
                    it.show()
                }
            }
        }
    )
    if (showWaitDialog) {
        Dialog(onDismissRequest = {}) {
            LoadingAnimation()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(title = "Profile Edit", onBackClick = onBackClick)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(if (showWaitDialog) " " else profile!!.photo)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(200.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(onClick = { launcher.launch("image/*") }) {
                Text(text = "Изменить фото")
            }
            Button(
                onClick = {
                    viewModel.updateProfile(
                        ProfileEntity(
                            profile!!.id ,name, surname, profile!!.photo
                        )
                    )
                    onBackClick()
                }
            )
            {
                Text(text = "Сохранить")
            }


        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Имя")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        OutlinedTextField(
            value = surname,
            onValueChange = { surname = it },
            label = { Text(text = "Фамилия")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        )
    }
}

@Composable
private fun TopBar(
    onBackClick: () -> Unit = {},
    title : String
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick,
        modifier = Modifier.padding(1.dp)) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
        }
        Text(text = title, style = MaterialTheme.typography.titleLarge)
    }
}