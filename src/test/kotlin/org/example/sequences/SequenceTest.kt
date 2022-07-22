package org.example.sequences

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SequenceTest {
    @Test
    fun testEagerEvaluation() {
        val list = listOf(1, 2, 3, 4)
        assertEquals(list.filter { it % 2 == 0 }
            .map { it * it }
            .any { it < 10 }, true)
        // Equivalent to:
        val mid1 = list.filter { it % 2 == 0 }
        assertEquals(mid1, listOf(2, 4))
        val mid2 = mid1.map { it * it }
        assertEquals(mid2, listOf(4, 16))
        assertEquals(mid2.any { it < 10 }, true)
    }

    @Test
    fun testEagerVsLazyEvaluation() {
        val list = listOf(1, 2, 3, 4)
        var result = list
            .filter(Int::isEven)
            .map(Int::square)
            .any(Int::lessThanTen)
        assertTrue(result)

        result = list.asSequence().filter (Int::isEven)
            .map(Int::square)
            .any(Int::lessThanTen)
        assertTrue(result)
    }

    @Test
    fun testNoComputationYet(){
        val r = listOf(1, 2, 3, 4)
            .asSequence()
            .filter(Int::isEven)
            .map(Int::square)
        assertEquals(r.toString().substringBefore("@"), "kotlin.sequences.TransformingSequence")
    }

    @Test
    fun testTerminalOperations(){
        val list = listOf(1, 2, 3, 4)
        val result = list.asSequence()
                    .filter(Int::isEven)
                    .map(Int::square)
                    .toList()
        assertEquals(result, listOf(4, 16))
    }

    @Test
    fun testGenerateSequence() {
        val naturalNumbers =
            generateSequence(1) { it + 1 }
        assertEquals(naturalNumbers.take(3).toList(), listOf(1, 2, 3))
        assertEquals(naturalNumbers.take(10).sum(), 55)
    }

    @Test
    fun testGenerateAnotherWayOfCreateSequence() {
        val items = mutableListOf(
            "first", "second", "third", "XXX", "4th"
        )
        val seq = generateSequence {
            items.removeAt(0).takeIf { it != "XXX" }
        }
        assertEquals(seq.toList(), listOf("first", "second", "third"))
        try {
            seq.toList()
        } catch (e: Exception) {
            assertEquals("This sequence can be consumed only once.", e.message)
        }
    }

    @Test
    fun testDefineTakeIf() {
        assertEquals("abc".takeIf { it != "XXX" }, "abc")
        assertEquals("XXX".takeIf { it != "XXX" }, null)
    }

    @Test
    fun testGenerateSequenceWithTakeIf() {
        assertEquals(generateSequence(6) {
            (it - 1).takeIf { it > 0 }
        }.toList() , listOf(6, 5, 4, 3, 2, 1))
    }
}