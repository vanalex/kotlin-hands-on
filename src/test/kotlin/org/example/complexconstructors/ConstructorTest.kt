package org.example.complexconstructors

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConstructorTest {

    @Test
    fun testBasicConstructor(){
        val alien = Alien("Pencilvester")
        assertEquals(alien.name , "Pencilvester")
    }

    @Test
    fun testInitContext(){
        val m1 = Message("Big ba-da boom!")
        assertEquals( m1.toString(), "[10] Big ba-da boom!")
        val m2 = Message("Bzzzzt!")
        assertEquals(m2.toString(), "[20] Bzzzzt!")
    }
}