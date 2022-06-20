package com.to_panelka.zine.screens.students

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.to_panelka.zine.repository.entities.StudentEntity
import com.to_panelka.zine.ui.composable.ItemListMenu
import com.to_panelka.zine.viewModels.StudentsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentsScreen(
    viewModel: StudentsViewModel,
    onStudentClick: (String) -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    val allStudents by viewModel.allStudents.observeAsState(listOf())
    Scaffold(
        floatingActionButton = {
            LargeFloatingActionButton(onClick = onAddClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            allStudents.forEach {
                item {
                    ItemListMenu(text = it.name, onClick = onStudentClick)
                }
            }
        }
    }
}

@Composable
fun SingleStudentScreen(
    student: String,
    onDeleteClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = student,
            style = MaterialTheme.typography.displayMedium
        )
        Button(onClick = onDeleteClick) {
            Text(text = "Delete")
        }
    }
}


@Composable
fun AddStudentScreen(
    onAddClick: (String) -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    Column {
        TextField(value = name, onValueChange = { name = it })
        Button(onClick = { onAddClick(name) }) {
            Text(text = "Создать")
        }
    }
}