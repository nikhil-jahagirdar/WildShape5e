package com.example.wildshape5e.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterPopUp(name : String, content: @Composable (() -> Unit)) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(color = Color.LightGray)
    ) {
        Text(text = name)
        content()

    }
}