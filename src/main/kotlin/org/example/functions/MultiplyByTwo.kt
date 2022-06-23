package org.example.functions

fun multiplyBYTwo(x: Int): Int{
    println("multiplying by two")
    return x* 2;
}

fun main(){
    val result = multiplyBYTwo(1)
    println(result)
    val result2 = multiplyBYTwo(2)
    println(result2)
    val negativeResult = multiplyBYTwo(-3)
    println(negativeResult)
}