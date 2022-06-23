package org.example.properties

class House{
    var sofa: String = ""
}

fun main() {
    val house = House()
    house.sofa = "Sleeping sofa"
    println(house.sofa)
    house.sofa = "deep sleep sofa"
    println(house.sofa)
    //house = House() //cannot be reassign
}