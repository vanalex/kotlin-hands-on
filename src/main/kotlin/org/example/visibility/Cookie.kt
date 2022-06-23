package org.example.visibility

class Cookie(
    private var isReady : Boolean){
    private fun crumble() = println("crumble")
    private fun bite() = println("bite")
    fun eat(){
        isReady = true
        crumble()
        bite()
    }
}

fun main(){
    val cookie = Cookie(false)
    //cookie.bite() //cannot access private member
    //cookie.crumble() //cannot access private member
    cookie.eat()
}