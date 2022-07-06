package org.example.enumerations

enum class Direction(val notation: String) {
    North("N"), South("S"), East("E"), West("W");
    val opposite : Direction
    get() = when( this ){
        North -> South
        South -> North
        West -> East
        East -> West
    }
}