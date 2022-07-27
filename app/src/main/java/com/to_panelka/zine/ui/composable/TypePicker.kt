package com.to_panelka.zine.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.to_panelka.zine.database.entities.Type


@Composable
fun TypePicker(
    category : String,
    onCategoryChanged : (String) -> Unit
){
    var expanded by remember {
        mutableStateOf(false)
    }
    Column() {
        Text(text = category,
        modifier = Modifier.clickable { expanded = true })
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false}) {
            Type.values().toList().forEach {
                DropdownMenuItem(text = { Text(text = it.name)}, onClick = {onCategoryChanged(it.name)})
            }
        }
    }

}