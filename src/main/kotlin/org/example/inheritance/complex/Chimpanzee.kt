package org.example.inheritance.complex

class Chimpanzee : GreatApe() {

    // New property:
    val additionalEnergy = 20
    override fun call() = "Yawp!"
    override fun eat() {
        energy += additionalEnergy
        super.eat()
    }
    // Add a function:
    fun jump() = "Chimp jump"
}