package org.example.highorderfunction

import org.example.highorderfunctions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HighOrderFunctionTest {

    @Test
    fun basicTest(){
        var isPlus = isPlus(3)
        assertTrue(isPlus)
        isPlus = isPlus(-1)
        assertFalse(isPlus)
    }

    @Test
    fun helloWorldTest(){
        val greet = greet()
        assertEquals("Hello World", greet)
    }

    @Test
    fun testAnyAsHighOrderFunction() {
        val ints = listOf(1, 2, -3)
        assertEquals(ints.any { it > 0 }, true)
        val strings = listOf("abc", " ")
        assertEquals(strings.any { it.isBlank() }, true)
        assertEquals(strings.any(String::isNotBlank), true)
    }

    @Test
    fun testTransformStringToInt(){
        val transformedValue = transformStringToInt("123")
        assertEquals(123, transformedValue)
        val transformedValueAsNull = transformStringToInt("abc")
        assertEquals(null, transformedValueAsNull)

        val x = listOf("112", "abc")
        var transformedToInt = x.mapNotNull { transformedValue }
        assertEquals(transformedToInt, listOf(123, 123))
        transformedToInt = x.mapNotNull {  it.toIntOrNull() }
        assertEquals(transformedToInt, listOf(112))
    }

    @Test
    fun testNllableFunction() {
        val returnTypeNullable: (String) -> Int? = { null }
        val mightBeNull: ((String) -> Int)? = null
        assertEquals(returnTypeNullable("abc"), null)
        // Doesn't compile without a null check:
        // mightBeNull("abc")
    }
}