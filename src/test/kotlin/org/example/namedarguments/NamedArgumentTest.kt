package org.example.namedarguments

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NamedArgumentTest {
    @Test
    fun namedArgumentTest(){
        assertEquals(color(1, 2, 3), "(1, 2, 3)")
        assertEquals(color(red = 76, green = 89, blue = 0), "(76, 89, 0)")
        assertEquals(color(52, 34, blue = 0), "(52, 34, 0)")
    }

    @Test
    fun argumentOrderTest(){
        assertEquals(color(blue = 0, red = 99, green = 52), "(99, 52, 0)")
        assertEquals(color(red = 255, 255, 0),"(255, 255, 0)")
    }

    @Test
    fun namedAndDefaultArgumentTest() {
        assertEquals(colors(139), "(139, 0, 0)")
        assertEquals(colors(blue = 139), "(0, 0, 139)")
        assertEquals(colors(255, 165), "(255, 165, 0)")
        assertEquals(colors(red = 128, blue = 128), "(128, 0, 128)")
    }

    @Test
    fun colorTest(){
        assertEquals( Color(red = 77).toString(), "(77, 0, 0)")
    }

    @Test
    fun testCreateStrings() {
        val list = listOf(1, 2, 3,)
        assertEquals(list.toString(), "[1, 2, 3]")
        assertEquals(list.joinToString(), "1, 2, 3")
        assertEquals(list.joinToString(prefix = "(", postfix = ")"), "(1, 2, 3)")
        assertEquals(list.joinToString(separator = ":"), "1:2:3")
    }

    @Test
    fun testEvaluation() {
        h()
        h()
    }

    @Test
    fun testCreationStrings() {
        val list = listOf(1, 2, 3)
        assertEquals(list.joinToString(". ", "", "!"), "1. 2. 3!")
        assertEquals(list.joinToString(separator = ". ", postfix = "!"), "1. 2. 3!")
    }

    @Test
    fun trimMarginTest() {
        val poem = """
|->Last night I saw upon the stair
|->A little man who wasn't there
|->He wasn't there again today
|->Oh, how I wish he'd go away."""
        assertEquals(poem.trimMargin(),
                """->Last night I saw upon the stair
->A little man who wasn't there
->He wasn't there again today
->Oh, how I wish he'd go away.""")
        assertEquals(poem.trimMargin(marginPrefix = "|->"),
                """Last night I saw upon the stair
A little man who wasn't there
He wasn't there again today
Oh, how I wish he'd go away.""")
    }
}