package org.example.recursion

fun factorial(n: Long): Long {
    if (n <= 1) return 1
    return n * factorial(n - 1)
}

fun illegalState() {
 throw IllegalStateException()
}
fun fail() = illegalState()

fun recurse(i: Int): Int = recurse(i + 1)

fun sum(n: Long): Long {
    if (n == 0L) return 0
    return n + sum(n - 1)
}

fun sumWithAcc(n: Long): Long {
    var accumulator = 0L
    for (i in 1..n) {
        accumulator += i
    }
    return accumulator
}