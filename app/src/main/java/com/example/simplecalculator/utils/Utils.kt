package com.example.simplecalculator.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * creates the button of the calculator
 *
 * @param modifier to modify the box into it
 * @param text the text of calculator button
 * @param color color of calculator button
 * @param onClick it executes when we click on calculator button
 */
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
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 36.sp,
            maxLines = 1,
            color = Color.White
        )
    }
}

/**
 * deletes zero after the decimal point
 *
 * @param number the number with zero after the decimal point
 * @return the number without zero after the decimal point
 */
fun deleteZero(number: String): String {
    var _number = number
    if (number[number.length - 1] == '0' && number[number.length - 2] == '.') {
        _number = number.dropLast(1)
        _number = _number.dropLast(1)
    }
    return _number
}