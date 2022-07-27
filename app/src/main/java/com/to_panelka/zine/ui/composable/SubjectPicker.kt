package com.to_panelka.zine.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import com.to_panelka.zine.database.entities.SubjectEntity

@Composable
fun SubjectPicker(
    subjectList: List<SubjectEntity> = emptyList(),
    subject : String,
    onPickSubject: (String) -> Unit,
    createNewSubject: (SubjectEntity) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var isNew by remember {
        mutableStateOf(false)
    }
    Column() {
        Text(text = subject,
            modifier = Modifier.clickable { expanded = true })
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            subjectList.forEach { subjectEntity ->
                DropdownMenuItem(
                    text = { Text(text = subjectEntity.title) },
                    onClick = {
                        onPickSubject(subjectEntity.title)
                        expanded = false})
            }
            if (isNew) {
                var newSub by remember {
                    mutableStateOf("")
                }
                DropdownMenuItem(text = {
                    TextField(
                        value = newSub,
                        onValueChange = { newSub = it },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                createNewSubject(SubjectEntity(title = newSub))
                                onPickSubject(newSub)
                                isNew = false
                                expanded = false
                            },
                        )
                    )
                },
                    onClick = { /*TODO*/ })
            } else {
                DropdownMenuItem(text = { Text(text = "Создать") }, onClick = { isNew = true })
            }

        }
    }


}