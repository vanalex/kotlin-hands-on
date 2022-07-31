package org.example.inheritance.complex

class Bonobo : GreatApe(){
    override fun call() = "Eep!"
    override fun eat() {
    // Modify the base-class var:
        energy += 10
    // Call the base-class version:
        super.eat()
    }
    // Add a function:
    fun run() = "Bonobo run"
}