package org.example.namedarguments

class Color(val red: Int = 0, val blue: Int = 0, val green: Int= 0) {

    override fun toString(): String {
        return "red $red, green $green blue $blue"
    }
}