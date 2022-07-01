package org.example.whenexpression

class Coordinates {
    var x: Int = 0
        set(value) {
            field = value
        }
    var y: Int = 0
        set(value) {
            field = value
        }
    override fun toString() = "($x, $y)"
}

fun processInputs(inputs: List<String>, coordinates: Coordinates) {
    for (input in inputs) {
        when (input) { // [1]
            "up", "u" -> coordinates.y-- // [2]
            "down", "d" -> coordinates.y++
            "left", "l" -> coordinates.x--
            "right", "r" -> { // [3]
                coordinates.x++
            }
            "nowhere" -> {} // [4]
            "exit" -> return // [5]
            else -> println("bad input: $input")
        }
    }
}