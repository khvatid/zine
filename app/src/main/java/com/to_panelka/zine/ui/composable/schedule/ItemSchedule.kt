package com.to_panelka.zine.ui.composable.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemSchedule() {
    ElevatedCard(
        onClick = {}
        ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "10:39",
                     style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 2.dp))
                Text(text = "практика",
                    modifier = Modifier.padding(8.dp)
                        .background(
                            color = Color.Yellow,
                            shape = RoundedCornerShape(6.dp)
                        ).padding(horizontal = 4.dp, vertical = 1.dp)
                )
            }
            Text(
                text = "Математика",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
        }
    }
}

@Composable
@Preview(
    showBackground = true,
)
private fun Prev(){
    ItemSchedule()
}