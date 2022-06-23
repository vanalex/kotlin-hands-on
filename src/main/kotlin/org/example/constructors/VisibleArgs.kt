package org.example.constructors

class MutableNameAlien(var name: String) {
}

class FixedNameAlien(val name: String){
}

fun main(){
    val alien1 = MutableNameAlien("Mr Lee")
    val alien2 = FixedNameAlien("Mr Lou")
    alien1.name = "Mr Doe"
    // Can't do this:
    //alien2.name = "Mr Smith"
}