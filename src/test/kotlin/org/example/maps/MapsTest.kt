package org.example.maps

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MapsTest {

    @Test
    fun testBasic(){
        val constants = mapOf(
            "Pi" to 3.141,
            "e" to 2.718,
            "phi" to 1.618)

        assertEquals(constants.toString(), "{Pi=3.141, e=2.718, phi=1.618}")

        assertEquals(constants["e"], 2.718)
        assertEquals(constants.keys, setOf("Pi", "e", "phi"))
    }

    @Test
    fun testMutableMap(){
        val m = mutableMapOf(5 to "five", 6 to "six")
        assertEquals(m[5], "five")
        m[5] = "5ive"
        assertEquals(m[5], "5ive")
        m += 4 to "four"
        assertEquals(m, mapOf(5 to "5ive", 4 to "four", 6 to "six"))
    }

    @Test
    fun testReadOnlyMap() {
        val m = mapOf(5 to "five", 6 to "six")
        assertEquals(m[5], "five")
        // m[5] = "5ive" // Fails
        // m += (4 to "four") // Fails
        m + (4 to "four") // Doesn't change m
        assertEquals(m, mapOf(5 to "five", 6 to "six"))
        val m2 = m + (4 to "four")
        assertEquals(m2, mapOf(5 to "five", 6 to "six", 4 to "four"))
    }

    @Test
    fun testGetValue() {
        val map = mapOf('a' to "attempt")
        assertEquals( map['b'], null)
        try {
            map.getValue('b')
        }catch (exception: NoSuchElementException){
         assertEquals(exception.localizedMessage, "Key b is missing in the map.")
        }
        assertEquals(map.getOrDefault('a', "??"), "attempt")
        assertEquals(map.getOrDefault('b', "??"), "??")
    }

    @Test
    fun testContactMap() {
        val miffy = Contact("Miffy", "1-234-567890")
        val cleo = Contact("Cleo", "098-765-4321")
        val contacts = mapOf(
            miffy.phone to miffy,
            cleo.phone to cleo)
        assertEquals(contacts["1-234-567890"], miffy)
        assertEquals(contacts["1-111-111111"], null)
    }
}