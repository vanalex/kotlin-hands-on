package org.example.whenexpression

fun bmiMetricWithWhen(
    kg: Double,
    heightM: Double
): String {
    val bmi = kg / (heightM * heightM)
    return when {
        bmi < 18.5 -> "Underweight"
        bmi < 25 -> "Normal weight"
        else -> "Overweight"
    }
}