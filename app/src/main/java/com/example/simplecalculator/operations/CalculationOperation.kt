package com.example.simplecalculator.operations

sealed class CalculationOperation(val operator: Operator) {
    object Add : CalculationOperation(Operator.ADD)
    object Subtract : CalculationOperation(Operator.SUBTRACT)
    object Multiply : CalculationOperation(Operator.MULTIPLY)
    object Divide : CalculationOperation(Operator.DIVIDE)
}