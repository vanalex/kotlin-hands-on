package org.example.whenexpression

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WhenExpressionTest {

    @Test
    fun testBasicWhen(){
        assertEquals(ordinal(3), "dritte")
        assertEquals(ordinal(11), "elfte")
    }

    @Test
    fun testProcessInputs(){
        val coordinates = Coordinates()
        processInputs(listOf("up", "d", "nowhere", "left", "exit", "right", "r"), coordinates)
        assertEquals(coordinates.x, -1)
        assertEquals(coordinates.y, 0)
    }

    @Test
    fun testMatchingAgainstVals() {
        val yes = "A"
        val no = "B"
        val result = StringBuilder()
        for (choice in listOf(yes, no, yes)) {
            when (choice) {
                yes -> result.append("Hooray!")
                no -> result.append( " Too bad!")
            }
        }

        assertEquals(result.toString(), "Hooray! Too bad!Hooray!")
    }

    @Test
    fun testMixColors(){
        val colormixed = mixColors("red", "yellow")
        assertEquals(colormixed, "orange")
    }

    @Test
    fun testBmi() {
        assertEquals(bmiMetricWithWhen(72.57, 1.727), "Normal weight")
    }
}