package org.example.varargs

fun sum(vararg numbers: Int): Int{
    var total = 0
    for (n in numbers){ total+= n }
    return total
}

fun evaluate(vararg ints: Int) =
    "Size: ${ints.size}\n" +
            "Sum: ${ints.sum()}\n" +
                "Average: ${ints.average()}"


fun first(vararg numbers: Int): String{
    var result = ""
    for (i in numbers){
        result += "[$i]"
    }

    return result
}

fun second(vararg numbers: Int){
    first(* numbers)
}