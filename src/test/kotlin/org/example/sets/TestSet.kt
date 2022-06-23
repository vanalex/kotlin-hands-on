package com.kotlinlab.sets

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestSet {

    @Test
    fun testSet(){
        val actual = setOf(1, 3, 5, 7, 9)
        val expected = setOf(1, 3, 5, 7, 9)
        assertEquals(actual, expected)
    }

    @Test
    fun testSetOrder(){
        val actual = setOf(1, 3, 5, 7, 9)
        val expected = setOf(9, 7, 5, 3, 1)
        assertEquals(actual, expected)
    }

    @Test
    fun testNotRepeatedElements(){
        val expected = setOf(1, 3, 5, 7, 9)
        val actual = setOf(1, 3, 3, 5, 7, 7, 9)
        assertEquals(expected, actual)
    }

    @Test
    fun testMembership(){
        val actual = setOf(1, 3, 5, 7, 9)
        assertTrue(actual.contains(9))
        assertFalse(actual.contains(99))
    }

    @Test
    fun testSetContainsAnother(){
        val actual = setOf(1,2,3,4,5,6,7,8,9,0)
        assertTrue(actual.containsAll(setOf(1, 9, 2)))
    }

    @Test
    fun testSetUnion(){
        val set1 = setOf(1,2,3,4)
        val set2 = setOf(9,8,7,6)
        assertEquals(set2.union(set1), setOf(1,2,3,4,6,7,8,9))
    }

    @Test
    fun testIntersect(){
        val intSet = setOf(1, 1, 2, 3, 9, 9, 4)
        assertEquals(intSet.intersect(setOf(0, 1, 2, 7, 8)), setOf(1, 2))
    }

    @Test
    fun testSubstract() {
        val intSet = setOf(1, 1, 2, 3, 9, 9, 4)
        assertEquals(intSet.subtract(setOf(0, 1, 9, 10)), setOf(2, 3, 4))
    }

    @Test
    fun testListToSet() {
        val list = listOf(3, 3, 2, 1, 2)
        assertEquals(list.toSet(), setOf(1, 2, 3))
        assertEquals(list.distinct(), listOf(3, 2, 1))
        assertEquals("abbcc".toSet(), setOf('a', 'b', 'c'))
    }

    @Test
    fun testMutableSet() {
        val mutableSet = mutableSetOf<Int>()
        mutableSet += 42
        mutableSet += 42
        assertEquals(mutableSet, setOf(42))
        mutableSet -= 42
        assertEquals(mutableSet, setOf<Int>())
    }
}