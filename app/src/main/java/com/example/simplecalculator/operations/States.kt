package com.example.simplecalculator.operations

/**
 * The class that contains the first and second number and the operator
 *
 * @property num1 the first number
 * @property num2 the second number
 * @property operation the operator, add, subtract, multiply and divide
 */
data class States(
    val num1: String = "",
    val num2: String = "",
    val operation: CalculationOperation? = null
) {
    /**
     * to show the hole operating in the calculator
     *
     * @return num1...operator...num2
     */
    override fun toString(): String {
        return num1 + (operation?.operator?.operator?:"") + num2
    }
}
