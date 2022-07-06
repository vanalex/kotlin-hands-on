package org.example.enumerations

import kotlin.test.Test
import kotlin.test.assertEquals


class EnumerationsTest {

    @Test
    fun testLevel(){
        assertEquals(Level.High.toString(), "High")
    }

    @Test
    fun testSize(){
        assertEquals(Size.Gigantic.toString(), "Gigantic")
        assertEquals(Size.values().toList(), listOf(Size.Tiny, Size.Small, Size.Medium, Size.Large, Size.Huge, Size.Gigantic))
        assertEquals(Size.Tiny.ordinal, 0)
    }

    @Test
    fun testCheckLevel() {
        assertEquals(checkLevel(Level.Empty), "Alert: Empty")
        assertEquals(checkLevel(Level.Low), "Level Low OK")
        assertEquals(checkLevel(Level.Overflow), ">>> Overflow!")
    }

    @Test
    fun testDirection(){
        assertEquals(Direction.East.notation, "E")
        assertEquals(Direction.North.opposite, Direction.South)
    }
}