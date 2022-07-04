package com.to_panelka.zine.screens.students

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SingleStudentScreen(
    student: String,
    onDeleteClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    var showDialog by remember {
        mutableStateOf(false)
    }
    if (showDialog) {
        DeleteStudentDialog(
            name = student,
            onAccept = onDeleteClick,
            onDismiss = { showDialog = false })
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
            Text(
                text = student,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { showDialog = true }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "delete")
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(text = "Detailed information about the student will be follow.")
        }
    }
}

@Composable
fun DeleteStudentDialog(
    name: String,
    onDismiss: () -> Unit = {},
    onAccept: () -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onAccept) {
                Text("Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "No")
            }
        },
        title = { Text(text = "Warning delete") },
        text = {
            Text(text = "You want to delete $name?")
        }
    )
}

