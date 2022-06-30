package org.example.namedarguments

fun color(red: Int, green: Int, blue: Int) = "($red, $green, $blue)"
fun colors(red: Int = 0, green: Int = 0, blue: Int = 0, ) = "($red, $green, $blue)"