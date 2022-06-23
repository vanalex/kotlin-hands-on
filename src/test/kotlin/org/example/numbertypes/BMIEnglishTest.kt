package org.example.numbertypes

import org.example.numbertypes.bmiEnglish
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BMIEnglishTest {

    @Test
    fun testGivenValuesThenShouldBeUnderWeight(){
        val result = bmiEnglish(90, 190)
        assertEquals("Underweight", result)
    }
}