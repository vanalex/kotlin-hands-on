package org.example.extensions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class QuotingTest {

    @Test
    fun testQuotingWithExtensionFunction(){
        assertEquals("Hi".singleQuotes(), "'Hi'")
        assertEquals("Hi".doubleQuotes(), "\"Hi\"")
    }

    @Test
    fun testStrangeQuotingWithExtensionFunction(){
        assertEquals("Hi".strangeQuote(), "''Hi''")
        assertEquals("Hi".tooManyQuotes(), "\"\"Hi\"\"")
    }

    @Test
    fun testBookExtensionFuntion(){
        val result = Book("Moon").categorized("science fiction")
        assertEquals(result, "title: \"Moon\", category: science fiction")
    }
}