package org.example.breakandcontinue

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ControlsTest {
    @Test
    fun testBuildMutableListWithFor(){
        assertEquals(mutableListOf(0, 4, 12, 16, 20, 24, 28, 32, 36), buildNumsMutableListWithFor())
    }

    @Test
    fun testBuildMutableListWithWhile(){
        assertEquals(mutableListOf(0, 4, 12, 16, 20, 24, 28, 32, 36), buildNumsMutableListWithWhile())
    }

    @Test
    fun testBuildMutableListWithDoWhile(){
        assertEquals(mutableListOf(0, 4, 12, 16, 20, 24, 28, 32, 36), buildNumsMutableListWithDoWhile())
    }

    @Test
    fun testBuildMutableListWithForLabeled(){
        assertEquals(listOf("a1", "a2", "a3", "a4",
            "b1", "b2", "b3", "b4", "c1", "c2"), buildStringWithForLabel())
    }

    @Test
    fun testBuildMutableListWithWhileLabeled(){
        assertEquals(listOf("a1", "a2", "a3", "a4",
            "b1", "b2", "b3", "b4", "c1", "c2"), buildStringWithForLabel())
    }
}