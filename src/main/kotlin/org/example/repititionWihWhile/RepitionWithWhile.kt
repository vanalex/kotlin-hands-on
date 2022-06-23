package org.example.repititionWihWhile

fun condition(i : Int) = i < 100

fun main(){
    var i = 0
    while (condition(i)) {
        print(".")
        i += 10
    }
}