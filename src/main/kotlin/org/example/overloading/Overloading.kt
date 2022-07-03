package org.example.overloading

class Overloading {
    fun f() = 0
    fun f(n: Int) = n + 2
}

fun addInt(i: Int, j: Int) = i + j
fun addDouble(i: Double, j: Double) = i + j

fun add(i: Int, j: Int) = i + j
fun add(i: Double, j: Double) = i + j

