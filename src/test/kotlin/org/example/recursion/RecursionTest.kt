package org.example.recursion

import kotlin.test.Test
import kotlin.test.assertEquals

class RecursionTest {

    @Test
    fun testFactorial() {
        assertEquals( factorial(5), 120)
        assertEquals( factorial(17), 355687428096000)
    }

    @Test
    fun testInfiniteRecursion() {
        // println(recurse(1))
    }

    @Test
    fun testRecursionLimits() {
        assertEquals( sum(2), 3)
        assertEquals( sum(1000), 500500)
        // sum(100_000) eq 500050000
        assertEquals((1..100_000L).sum(), 5000050000)
    }

    @Test
    fun testIteration() {
        assertEquals(sumWithAcc(10000), 50005000)
        assertEquals(sumWithAcc(100000), 5000050000)
    }

    @Test
    fun testTailRec() {
        assertEquals( org.example.resursion.sum(2), 3)
        assertEquals( org.example.resursion.sum(10000), 50005000)
        assertEquals(org.example.resursion.sum(100000), 5000050000)
    }

}