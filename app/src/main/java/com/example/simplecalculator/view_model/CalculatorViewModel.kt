package com.example.simplecalculator.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.simplecalculator.operations.Actions
import com.example.simplecalculator.operations.CalculationOperation
import com.example.simplecalculator.operations.States
import com.example.simplecalculator.utils.deleteZero

class CalculatorViewModel : ViewModel() {
    private var state by mutableStateOf(States())

    fun onAction(action: Actions) {
        when (action) {
            is Actions.Calculation -> onCalculation()
            is Actions.Decimal -> onDecimal()
            is Actions.Numbers -> onNumbers(action.number)
            is  Actions.Delete -> onDelete()
            is Actions.Clear -> state = States()
            is Actions.Operation -> onOperation(action.operation)
        }
    }

    private fun onOperation(operation: CalculationOperation) {
        if (state.num1.isNotBlank())
            state = state.copy(operation = operation)
    }

    private fun onDelete() {
        if (state.operation == null) {
            if (state.num1.isNotBlank()) {
                state = state.copy(num1 = state.num1.dropLast(1))
                return
            }
        }
        if (state.operation != null && state.num2.isBlank()) {
            state = state.copy(operation = null)
            return
        }

        state = state.copy(num2 = state.num2.dropLast(1))
    }

    private fun onNumbers(number: Int) {
        if (state.operation == null) {
            if (state.num1.length >= MAX_LENGTH) return
            state = state.copy(num1 = state.num1 + number)
            return
        }

        if (state.num2.length >= MAX_LENGTH) return
        state = state.copy(num2 = state.num2 + number)
    }

    private fun onDecimal() {
        if (state.operation == null) {
            if (state.num1.isNotBlank() && !state.num1.contains(".")) {
                state = state.copy(num1 = state.num1 + ".")
                return
            }
        }

        if (state.num2.isNotBlank() && !state.num2.contains(".")) {
            state = state.copy(num2 = state.num2 + ".")
            return
        }
    }

    private fun onCalculation() {
        val num1 = state.num1.toDoubleOrNull()
        val num2 = state.num2.toDoubleOrNull()
        if (num1 != null && num2 != null) {
            val result = when (state.operation) {
                is CalculationOperation.Add -> num1 + num2
                is CalculationOperation.Subtract -> num1 - num2
                is CalculationOperation.Multiply -> num1 * num2
                is CalculationOperation.Divide -> num1 / num2
                else -> {return}
            }
            state = state.copy(
                num1 = deleteZero(result.toBigDecimal().toPlainString().take(16)),
                num2 = "",
                operation = null
            )
        }
    }
    companion object {
        const val MAX_LENGTH = 8
    }
}