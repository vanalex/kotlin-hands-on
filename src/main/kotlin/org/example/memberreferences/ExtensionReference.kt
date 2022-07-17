package org.example.memberreferences

fun Int.times47() = times(47)

class Frog
fun Frog.speak() = "Ribbit!"

fun goInt(n: Int, g: (Int) -> Int) = g(n)
fun goFrog(frog: Frog, g: (Frog) -> String) = g(frog)