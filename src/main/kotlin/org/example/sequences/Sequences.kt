package org.example.sequences

fun Int.isEven(): Boolean{
    return this % 2 == 0
}

fun Int.square(): Int {
    return this * this
}

fun Int.lessThanTen(): Boolean {
    return this < 10
}

fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
    return if (predicate(this)) this else null
}