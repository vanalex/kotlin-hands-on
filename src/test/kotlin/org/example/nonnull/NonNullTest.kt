package org.example.nonnull

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NonNullTest {

    @Test
    fun testNonnull() {
        val s: String? = "abc"
        assertEquals( s!!.length, 3)
    }

    @Test
    fun testValueFromMap() {
        val map = mapOf(1 to "one")
        assertEquals(map[1]!!.toUpperCase(), "ONE")
        assertEquals(map.getValue(1).toUpperCase(), "ONE")
        try {
            map[2]!!.toUpperCase()
        }catch (e: Exception){
            assertEquals(e.message, null)
        }
        try {
            map.getValue(2).toUpperCase()
        }catch (e: Exception){
            assertEquals(e.message,"Key 2 is missing in the map.")
        }
    }
}