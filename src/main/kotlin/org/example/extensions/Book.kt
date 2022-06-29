package org.example.extensions

class Book(val title: String) {}

fun Book.categorized(category: String) = """title: "$title", category: $category"""