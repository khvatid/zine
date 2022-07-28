package com.to_panelka.zine.screens.schedule

import android.app.TimePickerDialog

import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.gestures.detectTapGestures

import androidx.compose.foundation.layout.Row

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback

import com.to_panelka.zine.database.entities.SubjectEntity

import com.to_panelka.zine.ui.composable.SubjectPicker
import com.to_panelka.zine.ui.composable.TypePicker
import com.to_panelka.zine.ui.composable.WeekSwitch
import com.to_panelka.zine.ui.composable.WheelPicker

import java.util.*


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun EditScheduleCard(
    onSaveClick: () -> Unit = {},
    createNewSubject: (SubjectEntity) -> Unit,
    subjectList : List<SubjectEntity>
) {


    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]
    val mTime = remember { mutableStateOf("") }
    val context = LocalContext.current
    val haptic = LocalHapticFeedback.current
    val mTimePickerDialog = TimePickerDialog(
        context,
        { _, mHour: Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
        }, mHour, mMinute, true
    )
    var weekCheck by remember {
        mutableStateOf(false)
    }
    var subject by remember {
        mutableStateOf("")
    }
    var category by remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    },
                    onTap = {
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                    }
                )
            },
    ) {
        Row {
            Text(text = "Time: ")
            WheelPicker(list = (0..23).toList())
        }
        Row() {
            Text(text = "Week")
            WeekSwitch(checked = weekCheck, onCheckedChange = { weekCheck = it })
        }
        Row() {
            Text(text = "Label")
            SubjectPicker(
                subjectList = subjectList,
                subject = subject,
                onPickSubject = { subject = it },
                createNewSubject = createNewSubject
            )
        }
        Row() {
            Text(text = "Type")
            TypePicker(category = category, onCategoryChanged = {category = it})
        }
    }


    /* Card() {
         Button(onClick = {mTimePickerDialog.show()}) {
             Text(text = if(mTime.value=="")"Установить Время" else mTime.value)
         }
         Row{
             Text(text = "Неделя")
             Switch(
                 checked = isOdd,
                 onCheckedChange = {isOdd = it},
             thumbContent = {
                 if (isOdd)
                 Text(text = "1")
                 else
                     Text(text = "2")
             })
         }
         Row() {
             Text(text = "Название")
             /* TODO create subject select */
         }
         Row() {
             Text(text = "category")
             Text(text = category,
             modifier = Modifier.clickable { expanded = true })
             DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                 Type.values().toList().forEach {
                     DropdownMenuItem(text = { Text(text = it.name)}, onClick = { category = it.name })
                 }
             }
         }

     }*/
}


@Composable
fun ScheduleCard() {
}
