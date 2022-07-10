package org.example.safecallsandelvis

import java.util.*

fun String.echo(){
    println(uppercase(Locale.getDefault()))
    println(this)
    println(lowercase(Locale.getDefault()))
}

fun checkLength(s: String?, expected: Int?): Pair<Int?, Int?> {
    val length1 = if (s != null) s.length else null
    val length2 = s?.length
    return Pair(length1, length2)
}