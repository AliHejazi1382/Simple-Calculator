package com.example.simplecalculator.operations

/**
 * to specify the operator of the operation
 *
 * @property operator contains the operator
 */
enum class Operator(val operator: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("×"),
    DIVIDE("÷")
}