package org.example.lambdas

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PartitionTest {

    @Test
    fun testPartition() {
        val list = listOf(-3, -1, 5, 7, 10)
        val isPositive = { i: Int -> i > 0 }
        assertEquals(list.filter(isPositive) , listOf(5, 7, 10))
        assertEquals(list.filterNot(isPositive), listOf( -3, -1))
        val (pos, neg) = list.partition { it > 0 }
        assertEquals(pos, listOf(5, 7, 10))
        assertEquals(neg, listOf(-3, -1))
    }

    fun createPair() = Pair(1, "one")

    @Test
    fun testPair(){
        val (i, s) = createPair()
        assertEquals(i, 1)
        assertEquals(s, "one")
    }
}