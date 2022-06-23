package org.example.properties

class Cup {
    var percentFull = 0
}

fun main(){
    val cup = Cup()
    println(cup.percentFull)
    cup.percentFull = 50
    println(cup.percentFull)
}