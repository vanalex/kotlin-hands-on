package org.example.expressions

fun findMax(first: Int, second: Int): Int =
    if (first > second) first else second

fun main() {
    println(findMax(-1, 4))  // 4
}