package com.to_panelka.zine.ui.composable

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun WeekSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(checked = checked, onCheckedChange = onCheckedChange,
        thumbContent = {
            if (checked) {
                Text(text = "1")
            } else {
                Text(text = "2")
            }
        }
    )
}