package org.example.overloading

class My {
    fun foo() = 0
}

fun My.foo() = 1

fun My.foo(n: Int) = n + 2

fun f(n: Int = 0) = n + 373