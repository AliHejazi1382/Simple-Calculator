package com.example.simplecalculator.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    modifier: Modifier,
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = text,
            fontSize = 36.sp,
            maxLines = 1,
            color = Color.White
        )
    }
}

fun deleteZero(number: String): String {
    var _number = number
    if (number[number.length - 1] == '0' && number[number.length - 2] == '.') {
        _number = number.dropLast(1)
        _number = _number.dropLast(1)
    }
    return _number
}