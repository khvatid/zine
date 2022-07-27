package com.to_panelka.zine.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.text.input.ImeAction
import com.to_panelka.zine.database.entities.SubjectEntity
import com.to_panelka.zine.screens.schedule.EditScheduleCard
import com.to_panelka.zine.viewModels.ScheduleViewModel

@Composable
fun CreateScheduleScreen(viewModel: ScheduleViewModel) {
    val allSubject by viewModel.allSubject.observeAsState(listOf())

    Column(modifier = Modifier.fillMaxSize()) {
        EditScheduleCard(
            createNewSubject = {viewModel.insertSubject(it)},
            subjectList = allSubject
        )
        LazyColumn {
            allSubject.forEach { subject ->
                item {
                    Text(text = subject.title)
                }
            }

        }
    }
}