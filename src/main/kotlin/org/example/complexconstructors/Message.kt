package org.example.complexconstructors

private var counter = 0

class Message(text: String) {
    private val content: String
    init {
        counter += 10
        content = "[$counter] $text"
    }

    override fun toString() = content
}