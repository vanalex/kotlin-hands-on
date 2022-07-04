package org.example.whenexpression

fun mixColors(first: String, second: String): String{
    return when(setOf(first, second)){
        setOf("red", "blue") -> "purple"
        setOf("red", "yellow") -> "orange"
        setOf("blue", "yellow") -> "green"
        else -> return "unknown"
    }
}