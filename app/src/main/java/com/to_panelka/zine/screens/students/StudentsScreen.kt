package com.to_panelka.zine.screens.students

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.to_panelka.zine.ui.composable.ItemStudentList
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
        topBar = {
            StudentTopBar(
                onAddClick = onAddClick
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            allStudents.forEach {
                item{
                    ItemStudentList(text = it.name, onClick = onStudentClick)
                }
            }
        }
    }

}

@Composable
fun StudentTopBar(
    onAddClick: () -> Unit = {}
) {
    SmallTopAppBar(
        title = {Text("Students")},
        actions = {
            IconButton(onClick = onAddClick) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add student")
            }
        }
    )
}
