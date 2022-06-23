package org.example.expressions

fun abs(number: Int): Int =
    if (number >= 0) number else - number

fun main(){
    println(abs(-3))
}