package org.example.generics

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GenericsTest {

    @Test
    fun testGenericHolder(){
        val genericHolder = GenericHolder(5)
        assertEquals(genericHolder.getValue(), 5)

        val h1 = GenericHolder(Automobile("Ford"))
        val a: Automobile = h1.getValue() // [2]
        assertEquals(a.toString(), "Automobile(brand=Ford)")
    }

    @Test
    fun testAnyHolder() {
        val holder = AnyHolder(Dog())
        val any = holder.getValue()
        // Doesn't compile:
        //any.bark()
        val genericHolder = GenericHolder(Dog())
        val dog = genericHolder.getValue()
        assertEquals(dog.bark(), "Ruff!")
    }

    @Test
    fun testGenericFunctions(){
        val result = identity("yellow")
        assertEquals(result, "yellow")
        assertEquals(identity(1), 1)
        val d: Dog = identity(Dog())
        assertEquals(d.bark(), "Ruff!")
    }

    @Test
    fun testIsEmptyOrNull(){
        val numbers = listOf(1, 2, 3)
        assertEquals(numbers.first(), 1)
        val i : Int? = numbers.firstOrNull()
        assertEquals(i, 1)
        val s: String? = listOf<String>().firstOrNull()
        assertNull(s)
    }
}