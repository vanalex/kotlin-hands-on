package org.example.constructors

class Scientist(val name: String) {
    override fun toString(): String {
        return "Scientist('$name')"
    }
}

fun main(){
    val crazyScientist = Scientist("crazy Scientist")
    println(crazyScientist)
}