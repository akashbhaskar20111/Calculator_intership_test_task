package com.example.intership_calcultor

import androidx.compose.runtime.Composable
import net.objecthunter.exp4j.ExpressionBuilder

fun evaluateExpression(expression: String): Double {
    try {
        val exp = ExpressionBuilder(expression).build()
        return exp.evaluate()
    } catch (e: Exception) {
        // Handle the exception, e.g., log or return a specific value for errors
        throw IllegalArgumentException("Invalid expression: $expression")
    }
}
