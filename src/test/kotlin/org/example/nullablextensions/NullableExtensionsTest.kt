package org.example.nullablextensions

import org.example.isNullOrEmpty
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NullableExtensionsTest {
    @Test
    fun test(){
        val s1: String? = null
        assertEquals(s1.isNullOrEmpty(), true)
        assertEquals(s1.isNullOrBlank(), true)
        val s2 = ""
        assertEquals(s2.isNullOrEmpty(), true)
        assertEquals(s2.isNullOrBlank(), true)
        val s3: String = " \t\n"
        assertEquals(s3.isNullOrEmpty(), false)
        assertEquals(s3.isNullOrBlank(), true)
    }

    @Test
    fun main() {
        assertEquals("".isNullOrEmpty(), true)
    }
}