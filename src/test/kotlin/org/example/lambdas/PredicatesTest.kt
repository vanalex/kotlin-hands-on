package org.example.lambdas

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PredicatesTest {
    @Test
    fun testPredicates() {
        val list = listOf(-3, -1, 5, 7, 10)
        assertEquals(list.filter { it > 0 }, listOf(5, 7, 10))
        assertEquals(list.count { it > 0 }, 3)
        assertEquals(list.find { it > 0 }, 5)
        assertEquals(list.firstOrNull { it > 0 }, 5)
        assertEquals(list.lastOrNull { it < 0 }, -1)
        assertEquals(list.any { it > 0 }, true)
        assertEquals(list.any { it != 0 }, true)
        assertEquals(list.all { it > 0 }, false)
        assertEquals(list.all { it != 0 }, true)
        assertEquals(list.none { it > 0 }, false)
        assertEquals(list.none { it == 0 }, true)
    }
}