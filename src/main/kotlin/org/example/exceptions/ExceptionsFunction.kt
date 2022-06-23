package org.example.exceptions

fun erroneousCode(){
    val i = "1$".toInt()
}

fun averageIncome(income: Int, months: Int) = income / months

fun averageIncomeWithNull(income: Int, months: Int) = if (months == 0) null else income / months

fun averageIncomeWithException(income: Int, months: Int) = if (months == 0) throw IllegalArgumentException("Months can't be zero") else income / months