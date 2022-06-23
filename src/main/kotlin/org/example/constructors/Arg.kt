package org.example.constructors

class Alien(name: String){
    val greeting = "poor $name"
}

fun main() {
    val alien = Alien("Mr Meeseks")
    println(alien.greeting)
    //alien.name // Error // [1]
}