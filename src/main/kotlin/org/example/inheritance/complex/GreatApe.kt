package org.example.inheritance.complex

open class GreatApe {

    protected var energy = 0
    open fun call() = "Hoo!"
    open fun eat() {
        energy += 10
    }
    fun climb(x: Int) {
        energy -= x
    }
    fun energyLevel() = "Energy: $energy"

    fun talk(ape: GreatApe): String {
// ape.run() // Not an ape function
// ape.jump() // Nor this
        ape.eat()
        ape.climb(10)
        return "${ape.call()} ${ape.energyLevel()}"
    }
}