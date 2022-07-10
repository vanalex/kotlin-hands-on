package org.example.safecallsandelvis

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SafeCallsTest {

    @Test
    fun testElvisOperator() {
        val s1: String? = "abc"
        assertEquals((s1 ?: "---"), "abc")
        val s2: String? = null
        assertEquals((s2 ?: "---"), "---")
    }

    @Test
    fun main() {
        val alice = Person("Alice")
        assertEquals(alice.friend?.friend?.name, null) // [1]
        val bob = Person("Bob")
        val charlie = Person("Charlie", bob)
        bob.friend = charlie
        assertEquals(bob.friend?.friend?.name, "Bob") // [2]
        assertEquals((alice.friend?.friend?.name ?: "Unknown"), "Unknown") // [3]
    }

    @Test
    fun testCheckLength() {
        val result = checkLength("abc", 3)
        assertEquals(Pair(3, 3), Pair(3, 3))
        val result2 = checkLength(null, null)
        assertEquals(result2, Pair(null, null))
    }

    @Test
    fun testChainedCalls() {
        val alice = Person("Alice")
        assertEquals(alice.friend?.friend?.name, null)
        val bob = Person("Bob")
        val charlie = Person("Charlie", bob)
        bob.friend = charlie
        assertEquals(bob.friend?.friend?.name, "Bob")
        assertEquals(alice.friend?.friend?.name ?: "Unknown", "Unknown")
    }
}