package org.example.generics

fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Empty List")
    return this[0]
}

fun <T> List<T>.firstOrNull(): T? = if (isEmpty()) null else this[0]