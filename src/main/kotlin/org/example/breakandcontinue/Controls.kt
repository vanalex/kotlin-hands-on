package org.example.breakandcontinue

fun buildNumsMutableListWithFor(): List<Int> {
    val nums = mutableListOf(0)
    for (i in 4 until 100 step 4) { // [1]
        if (i == 8) continue // [2]
        if (i == 40) break // [3]
        nums.add(i)
    }

    return nums
}

fun buildNumsMutableListWithWhile(): List<Int> {
    val nums = mutableListOf(0)
    var i = 0
    while (i < 100) {
        i += 4
        if (i == 8) continue
        if (i == 40) break
        nums.add(i)
    }

    return nums
}

fun buildNumsMutableListWithDoWhile(): List<Int> {
    val nums = mutableListOf(0)
    var i = 0
    do {
        i += 4
        if (i == 8) continue
        if (i == 40) break
        nums.add(i)
    } while (i < 100)
    return nums
}

fun buildStringWithForLabel(): MutableList<String> {
    val strings = mutableListOf<String>()
    outer@ for (c in 'a'..'e') {
        for (i in 1..9) {
            if (i == 5) continue@outer
            if ("$c$i" == "c3") break@outer
            strings.add("$c$i")
        }
    }
    return strings
}

fun buildStringWithWhileLabel(): List<String> {
    val strings = mutableListOf<String>()
    var c = 'a' - 1
    outer@ while (c < 'f') {
        c += 1
        var i = 0
        do {
            i++
            if (i == 5) continue@outer
            if ("$c$i" == "c3") break@outer
            strings.add("$c$i")
        } while (i < 10)
    }
    return strings
}