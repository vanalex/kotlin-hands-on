package org.example.secondaryconstructors

class WithSecondary(i: Int) {

    init {
        println("Primary: $i")
    }

    constructor(c: Char) : this(c - 'A')

    constructor(s: String) :
            this(s.first()) {
        println("Secondary: \"$s\"")
    }
}