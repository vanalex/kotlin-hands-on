package org.example.numbertypes

fun bmiMetric(weight: Double,
              height: Double): String {
        val bmi = weight / (height * height)
    return if (bmi < 18.5) "Underweight" else if ( bmi < 25 ) "Normal Weight" else "Overweight"
}

fun main(){
    val weight = 72.57 // 160 lbs
    val height = 1.727 // 68 inches
    val status = bmiMetric(weight, height)
    println(status)
}