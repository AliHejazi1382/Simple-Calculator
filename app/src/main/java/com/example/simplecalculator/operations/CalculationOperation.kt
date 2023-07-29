package com.example.simplecalculator.operations

/**
 * functionality of operation
 *
 * @property operator contains the operator
 */
sealed class CalculationOperation(val operator: Operator) {
    object Add : CalculationOperation(Operator.ADD)
    object Subtract : CalculationOperation(Operator.SUBTRACT)
    object Multiply : CalculationOperation(Operator.MULTIPLY)
    object Divide : CalculationOperation(Operator.DIVIDE)
}