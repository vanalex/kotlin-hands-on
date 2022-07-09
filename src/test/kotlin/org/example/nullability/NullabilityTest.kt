package org.example.nullability

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class NullabilityTest {
    @Test
    fun testNullInMaps(){
        val map = mapOf(0 to "yes", 1 to "no")
        assertEquals(map[2], null)
    }

    @Test
    fun main() {
        val s1 = "abc" // [1]
        // Compile-time error:
        // val s2: String = null // [2]
        // Nullable definitions:
        val s3: String? = null // [3]
        val s4: String? = s1 // [4]
        // Compile-time error:
        // val s5: String = s4 // [5]
        val s6 = s4 // [6]
        assertEquals(s1, "abc")
        assertEquals(s3, null)
        assertEquals(s4, "abc")
        assertEquals(s6, "abc")
    }

    @Test
    fun testNullInMap(){
        val map = mapOf(0 to "yes", 1 to "no")
        val first: String? = map[0]
        val second: String? = map[2]
        assertEquals(first, "yes")
        assertEquals(second, null)
    }

    @Test
    fun testDereference(){
        val s1: String = "abc"
        val s2: String? = s1
        assertEquals(s1.length, 3)
        // Doesn't compile:
        // s2.length

        if(s2 != null)
            assertEquals(s2.length, 3)
    }

    @Test
    fun testNullabilityByDefault() {
        val a1: Amphibian = Amphibian()
        val a2: Amphibian? = null
        val at1: Species = Species.Toad
        val at2: Species? = null
        assertNotNull(a1)
        assertNull(a2)
        assertNotNull(at1)
        assertNull(at2)
    }
}