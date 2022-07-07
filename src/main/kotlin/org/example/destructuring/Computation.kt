package org.example.destructuring

data class Computation(val data: Int,
                       val Info:String){
}

fun evaluate(input: Int) =
    if (input > 5)
        Computation(input * 2, "High")
    else
        Computation(input * 2, "Low")