package com.to_panelka.zine.ui.composable


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WheelPicker(
    list: List<Int>,
    itemSize: Int = 48,

) {
    val listState = rememberLazyListState()
    var current by remember {
        mutableStateOf(0)
    }
    if (!listState.isScrollInProgress) {
        LaunchedEffect(listState) {
            listState.scrollToItem(listState.firstVisibleItemIndex)
            current = listState.firstVisibleItemIndex
        }
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy((itemSize / 3).dp),
        modifier = Modifier.height(((itemSize * 3) + (itemSize / 3)).dp),
        state = listState,
        contentPadding = PaddingValues(top = itemSize.dp, bottom = (itemSize * 2).dp)
    ) {
        items(list) { item ->

            WheelItem(
                text = item.toString(),
                size = itemSize.dp,
                color = if (current == item) Color.Green else Color.Unspecified
            )
        }
    }


}

@Composable
fun WheelItem(
    size: Dp = 24.dp,
    text: String,
    color: Color = Color.Unspecified
) {
    Box(modifier = Modifier
        .size(size)
        .background(color = color, shape = RoundedCornerShape(25)),
    contentAlignment = Alignment.Center) {
        Text(
            text = text,
            fontSize = 20.sp,
        )
    }

}



