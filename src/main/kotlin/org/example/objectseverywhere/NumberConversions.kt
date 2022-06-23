package org.example.objectseverywhere

fun fraction(numnerator: Long, denominator: Long) = numnerator.toDouble() / denominator

fun main(){
    val numerator = 1
    val denominator = 2
    val f = fraction(numerator.toLong(), denominator.toLong())
    println(f)
}