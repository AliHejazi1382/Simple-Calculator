package com.example.simplecalculator.operations

/**
 * functionality of clicking on each calculator button
 *
 */
sealed class Actions {
    object Decimal : Actions()
    object Calculation : Actions()
    data class Numbers(val number: Int) : Actions()
    object Clear : Actions()
    object Delete : Actions()
    data class Operation(val operation: CalculationOperation) : Actions()
}
