package org.example.creatingclasses

class Hamster {
    private fun speak() = "squeak!"
    fun exercise() =
        this.speak() + speak() + "Running on wheels!"
}