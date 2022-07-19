package org.example.highorderfunctions

val isPlus : (Int) -> Boolean = {it > 0}

val greet :() -> String = {"Hello World"}

val transformStringToInt : (String) -> Int? = {s: String -> s.toIntOrNull()}

fun <T> List<T>.any(
    predicate: (T) -> Boolean
): Boolean {
    for (element in this) {
        if (predicate(element))
            return true
    }
    return false
}