package com.example.simplecalculator.operations

data class States(
    val num1: String = "",
    val num2: String = "",
    val operation: CalculationOperation? = null
) {
    override fun toString(): String {
        return num1 + (operation?.operator?.operator?:"") + num2
    }
}
