package org.example.extensionproperties

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PropertiesTest {

    @Test
    fun testStringIndices(){
        val result = "abcd".indices
        assertEquals(result, 0..3)
    }

    @Test
    fun testListExtensionProperties(){
        val result = listOf(1, 2, 3, 4, 5).firstOrNull
        assertEquals(result, 1)
        assertEquals(listOf<String>().firstOrNull, null)
    }

    @Test
    fun testListWithProjectionExtensionProperties(){
        val result = listOf(1, 2, 3, 4, 5).indices
        assertEquals(result, 0..4)
        assertEquals(listOf(1).indices, 0..0)
        assertEquals(listOf('a', 'b', 'c', 'd').indices, 0..3)
        assertEquals(emptyList<Int>().indices, IntRange.EMPTY)
    }

    @Test
    fun testAnyFromProjectionList() {
        val list: List<*> = listOf(1, 2)
        val any: Any? = list[0]
        assertEquals(any, 1)
    }
}