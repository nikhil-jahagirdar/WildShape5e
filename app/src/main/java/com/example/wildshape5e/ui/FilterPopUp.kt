package com.example.wildshape5e.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun FilterPopUp(name : String, onDone: (() -> Unit) = {}, onReset: (() -> Unit) = {}, content: @Composable (() -> Unit)) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
                .background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black)))
                .clickable { onDone() }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = name)
            content()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { onDone() },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Done", color = Color.White)
                }
                Button(
                    onClick = { onReset() },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Reset", color = Color.White)
                }
            }
        }
    }
}