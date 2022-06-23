package org.example.properties

class Sofa{
    val cover: String = "Loveseat cover"
}

fun main() {
    var sofa = Sofa()
    println(sofa.cover)
    //Not allowed
    //sofa.cover = "New cover";
    sofa = Sofa()
}
