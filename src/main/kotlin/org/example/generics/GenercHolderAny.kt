package org.example.generics

class AnyHolder(private val value: Any) {
    fun getValue(): Any = value
}
class Dog {
    fun bark() = "Ruff!"
}