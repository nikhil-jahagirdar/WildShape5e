package com.example.wildshape5e.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.chillibits.composenumberpicker.PickerButton
import com.example.wildshape5e.R

@Composable
fun MyPicker(
    width: Dp = 45.dp,
    min: Int = 0,
    max: Int = 30,
    default: Int = min,
    onValueChange: (Int) -> Unit = {},
) {
    val number = remember { mutableStateOf(default.toString()) }

    Column {
        PickerButton(
            size = width,
            drawable = R.drawable.ic_baseline_add_24,
            enabled = !number.value.isEmpty() && number.value.toInt() < max,
            onClick = {
                if (number.value.toInt() < max) {
                    number.value = (number.value.toInt() + 1).toString()
                }
                onValueChange(number.value.toInt())
            }
        )
        BasicTextField(
            value = number.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                val input = it.filter { it.isDigit() }
                if (!input.isEmpty()) {
                val numberEntered = input.toInt()
                val newNumber = if (numberEntered > max) max else if (numberEntered < min) min else numberEntered
                number.value = newNumber.toString()
                onValueChange(newNumber)
                } else {
                    number.value = ""
                }
            },
            singleLine = true,
            modifier = Modifier
                .padding(10.dp)
                .width(IntrinsicSize.Max)
                .align(CenterHorizontally)
        )
        PickerButton(
            size = width,
            drawable = R.drawable.ic_baseline_remove_24,
            enabled = !number.value.isEmpty() && number.value.toInt() > min,
            onClick = {
                if (number.value.toInt() > min) {
                    number.value = (number.value.toInt() - 1).toString()
                }
                onValueChange(number.value.toInt())
            }
        )
    }
}