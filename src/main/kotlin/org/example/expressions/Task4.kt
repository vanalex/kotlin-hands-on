package org.example.expressions

fun oneOrTheOther(exp: Boolean) =
    if (exp)
        "True!"
    else
        "False"

fun main() {
    val x = 1
    println(oneOrTheOther(x == 1))  // True!
}