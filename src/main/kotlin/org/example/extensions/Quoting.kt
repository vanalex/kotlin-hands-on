package org.example.extensions

fun String.singleQuotes() = "'$this'"
fun String.doubleQuotes() = "\"$this\""

fun String.strangeQuote() = this.singleQuotes().singleQuotes()
fun String.tooManyQuotes() = doubleQuotes().doubleQuotes()