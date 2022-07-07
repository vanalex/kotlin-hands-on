package org.example.destructuring

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DestructuringTest {
    @Test
    fun destructuringTest(){
        assertEquals( compute(7), Pair(14, "High"))
        assertEquals(compute(4), Pair(8, "Low"))
        val result = compute(5)
        assertEquals(result.first, 10)
        assertEquals(result.second, "Low")
    }

    @Test
    fun testDestructuringBasic() {
        val (value, description) = compute(7)
        assertEquals(value, 14)
        assertEquals(description, "High")
    }

    @Test
    fun testDestructuring() {
        val (value, description) = evaluate(7)
        assertEquals(value, 14)
        assertEquals(description, "High")
    }

    @Test
    fun testTuple() {
        val tuple = Tuple(1, 3.14, "Mouse", false, listOf())
        val (i, d, s, b, l) = tuple
        assertEquals(i, 1)
        assertEquals(d, 3.14)
        assertEquals(s, "Mouse")
        assertEquals(b, false)
        assertEquals(l, listOf())
        val (_, _, animal) = tuple // [1]
        assertEquals(animal, "Mouse")
    }

    @Test
    fun main() {
        var result = ""
        val list = listOf('a', 'b', 'c')
        for ((index, value) in list.withIndex()) {
            result+= ("$index:$value")
        }
        assertEquals( result, "0:a1:b2:c")
    }
}