package com.example.simplecalculator.ui.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.simplecalculator.R
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.operations.Actions
import com.example.simplecalculator.operations.CalculationOperation
import com.example.simplecalculator.operations.States
import com.example.simplecalculator.ui.theme.Orange
import com.example.simplecalculator.utils.CalculatorButton

/**
 * Builds a calculator from scratch
 *
 * @param spacedSize space between buttons
 * @param state state of numbers and operators
 * @param onAction Actions to do, decimal, delete etc
 */
@Composable
fun Calculator(
    spacedSize: Dp,
    state: States,
    onAction: (Actions) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Text(
                text = state.toString(),
                maxLines = 2,
                lineHeight = 60.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = if (state.toString().length < 6) 80.sp
                else if (state.toString().length in 6..10) 60.sp
                else 50.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(spacedSize)
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    text = stringResource(id = R.string.AC),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Clear) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.Del),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Delete) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.divide),
                    color = Orange,
                    onClick = { onAction(Actions.Operation(CalculationOperation.Divide)) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.spacedBy(spacedSize)
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.seven),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(7)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.eight),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(8)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.nine),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(9)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.multiply),
                    color = Orange,
                    onClick = { onAction(Actions.Operation(CalculationOperation.Multiply)) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.spacedBy(spacedSize)
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.four),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(4)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.five),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(5)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.six),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(6)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.subtract),
                    color = Orange,
                    onClick = { onAction(Actions.Operation(CalculationOperation.Subtract)) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.spacedBy(spacedSize)
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.one),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(1)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.two),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(2)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.three),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(3)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.add),
                    color = Orange,
                    onClick = { onAction(Actions.Operation(CalculationOperation.Add)) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.spacedBy(spacedSize)
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    text = stringResource(id = R.string.zero),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Numbers(0)) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.decimal),
                    color = Color.Gray,
                    onClick = { onAction(Actions.Decimal) }
                )
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    text = stringResource(id = R.string.calculate),
                    color = Orange,
                    onClick = { onAction(Actions.Calculation) }
                )
            }
        }
    }
}