package org.example.localfunctions

fun String.exclaim() = "$this!"

class Session(
    val title: String,
    val speaker: String
)

val sessions = listOf(Session("Kotlin Coroutines", "Roman Elizarov"))
val favoriteSpeakers = setOf("Roman Elizarov")


fun first(): (Int) -> Int {
    val func = fun(i: Int) = i + 1
    return func
}
fun second(): (String) -> String {
    val func2 = { s: String -> "$s!" }
    return func2
}
fun third(): () -> String {
    fun greet() = "Hi!"
    return ::greet
}
fun fourth() = fun() = "Hi!"
fun fifth() = { "Hi!"}