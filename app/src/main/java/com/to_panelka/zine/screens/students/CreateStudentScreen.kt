package com.to_panelka.zine.screens.students

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun CreateStudentScreen(
    onCreateClick: (String) -> Unit,
    onBackClick: () -> Unit = {}
) {
    var name by remember {
        mutableStateOf("")
    }
    var secondName by remember {
        mutableStateOf("")
    }
    val focus = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "cancel"
                )
            }
            Text(
                text = "New Student",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Имя") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focus.moveFocus(focusDirection = FocusDirection.Next) }),
            modifier = Modifier.padding(vertical = 5.dp)
        )
        OutlinedTextField(
            value = secondName,
            onValueChange = { secondName = it },
            label = { Text(text = "Фамилия") },
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { focus.clearFocus() }),
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Button(
            onClick = { onCreateClick("$secondName $name") },
            enabled = name != "" && secondName != ""
        ) {
            Text(text = "Create")
        }
    }
}