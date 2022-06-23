package org.example.functions

fun multiplyByFour(x: Int) = x * 4

fun main(){
    val result : Int = multiplyByFour(3)
    println(result)
    println(multiplyByFour(5))
}