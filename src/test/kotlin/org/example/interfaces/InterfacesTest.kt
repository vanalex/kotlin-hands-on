package org.example.interfaces

import kotlin.test.Test
import kotlin.test.assertEquals

class InterfacesTest {

    @Test
    fun testBasic() {
        val computers = listOf(Desktop(), DeepThought(), Quantum())
        assertEquals( computers.map { it.calculateAnswer() }, listOf(11, 42, -1))
        assertEquals(computers.map { it.prompt() }, listOf("Hello!", "Thinking...", "Probably..."))
    }

    @Test
    fun test() {
        assertEquals(listOf(Food(), Robot(), Wall('|')).map { it.symbol }, listOf('.', 'R', '|'))
    }

    @Test
    fun testEnumImplementsInterface() {
        assertEquals(SpiceLevel.values().map { it.feedback() },
            listOf("It adds flavor!",
                "Is it warm in here?",
                "I'm suddenly sweating a lot.",
                "I'm in pain. I am suffering.")
        )
    }

    @Test
    fun testSam() {
        assertEquals(verboseZero.f(), 11)
        assertEquals(samZero.f(), 11)
        assertEquals(verboseOne.g(92), 139)
        assertEquals(samOne.g(92), 139)
        assertEquals(verboseTwo.h(11, 47), 58)
        assertEquals(samTwo.h(11, 47), 58)
    }
}