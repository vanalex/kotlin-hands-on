package org.example.enumerations

enum class Level {
    Overflow, High, Medium, Low, Empty
}

fun checkLevel(level: Level): String{
    return when(level){
        Level.Overflow -> return ">>> Overflow!"
        Level.Empty -> return "Alert: Empty"
        else -> return "Level $level OK"

    }
}