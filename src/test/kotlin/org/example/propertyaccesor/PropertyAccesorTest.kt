package org.example.propertyaccesor

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PropertyAccesorTest {
    @Test
    fun accesorTest(){
        val data = Data(10)
        assertEquals(data.i, 10) // Read the 'i' property
        data.i = 20  // Write to the 'i' property
        assertEquals(data.i, 20)
    }

    @Test
    fun logChangesTest(){
        val lc = LogChanges()
        assertEquals( lc.n, 0)
        lc.n = 2
        assertEquals(lc.n, 2)
    }

    @Test
    fun main() {
        val cage = Cage(2)
        assertFalse(cage.full)
        assertEquals(cage.capacity, 2)
        assertTrue(cage.put(Hamster("Alice")))
        assertTrue(cage.put(Hamster("Bob")))
        assertTrue(cage.full)
        assertEquals(cage.capacity, 0)
        assertFalse(cage.put(Hamster("Charlie")))
        cage.take()
        assertEquals(cage.capacity, 1)
    }
}