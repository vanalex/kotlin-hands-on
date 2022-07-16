package org.example.generics

data class Automobile(val brand: String)

class GenericHolder<T>(private val value: T) {
    fun getValue(): T = value
}