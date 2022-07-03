package org.example.overloading

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OverloadingTest {

    @Test
    fun testOverloading(){
        val o = Overloading()
        assertEquals(o.f(), 0)
        assertEquals(o.f(11), 13)
    }

    @Test
    fun testNemberVsFunction(){
        assertEquals(My().foo(), 0)
        assertEquals(My().foo(2), 4)
        assertEquals(f(), 373)
    }

    @Test
    fun testAdd() {
        assertEquals(addInt(5, 6), add(5, 6))
        assertEquals(addDouble(56.23, 44.77), add(56.23, 44.77))
    }
}