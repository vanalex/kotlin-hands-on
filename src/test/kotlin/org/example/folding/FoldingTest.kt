package org.example.folding

import kotlin.test.Test
import kotlin.test.assertEquals

class FoldingTest {

    @Test
    fun testSumViaFold() {
        val list = listOf(1, 10, 100, 1000)
        assertEquals( list.fold(0) { sum, n ->
            sum + n
        }, 1111)
    }

    @Test
    fun testFoldVsForLoop(){
        val list = listOf(1, 10, 100, 1000)
        var accumulator = 0
        val operation =
            { sum: Int, i: Int -> sum + i }
        for (i in list) {
            accumulator = operation(accumulator, i)
        }
        assertEquals( accumulator, 1111)
    }

    @Test
    fun testFoldRight() {
        val list = listOf('a', 'b', 'c', 'd')
        assertEquals(list.fold("*") { acc, elem ->
            "($acc) + $elem"
        }, "((((*) + a) + b) + c) + d")
        assertEquals( list.foldRight("*") { elem, acc ->
            "$elem + ($acc)"
        }, "a + (b + (c + (d + (*))))")
    }

    @Test
    fun testReduceRight() {
        val chars = "A B C D E F G H I".split(" ")
        assertEquals(chars.fold("X") { a, e -> "$a $e" },
                "X A B C D E F G H I")
        assertEquals(chars.foldRight("X") { a, e -> "$a $e" },
                "A B C D E F G H I X")
        assertEquals(chars.reduce { a, e -> "$a $e" },
                "A B C D E F G H I")
        assertEquals(chars.reduceRight { a, e -> "$a $e" },
                "A B C D E F G H I")
    }

    @Test
    fun testRunningFold() {
        val list = listOf(11, 13, 17, 19)
        assertEquals(list.fold(7) { sum, n ->
            sum + n
        }, 67)
        assertEquals(list.runningFold(7) { sum, n ->
            sum + n
        }, listOf(7, 18, 31, 48, 67))
        assertEquals(list.reduce { sum, n ->
            sum + n
        }, 60)
        assertEquals(list.runningReduce { sum, n ->
            sum + n
        }, listOf(11, 24, 41, 60))
    }
}