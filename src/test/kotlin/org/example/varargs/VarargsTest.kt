package org.example.varargs

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class VarargsTest {
    @Test
    fun testBasicVarargs(){
        val result = sum(2, 5, 6, 9)
        assertEquals(result, 22)
    }

    @Test
    fun testEvaluateVarargsAsList(){
        val result = evaluate(2, 5, 6, 9)
        assertEquals(result, "Size: 4\nSum: 22\nAverage: 5.5")
    }

    @Test
    fun testSpreadOperator() {
        val array = intArrayOf(4, 5)
        assertEquals(sum(1, 2, 3, *array, 6), 21)
        // Doesn't compile:
        // sum(1, 2, 3, array, 6)
        val list = listOf(9, 10, 11)
        assertEquals(sum(*list.toIntArray()), 30)
    }
}