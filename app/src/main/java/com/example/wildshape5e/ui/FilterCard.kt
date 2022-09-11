package com.example.wildshape5e.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterCard(name : String, onClick : (() -> Unit)? = null) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick?.let { onClick() } }
        .padding(all = 2.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 4.dp
    ) {
        Box(
            modifier = Modifier.wrapContentSize()
                .padding(all = 6.dp),
        ) {
            Text(text = name)

        }
    }
}