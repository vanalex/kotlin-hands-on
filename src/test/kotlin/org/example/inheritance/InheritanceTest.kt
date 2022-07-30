package org.example.inheritance

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InheritanceTest {
    @Test
    fun basicTest(){
        fun main() {
            assertEquals(GreatApe().info(), "wt: 100.0 age: 12")
            assertEquals(Bonobo().info(), "wt: 100.0 age: 12")
            assertEquals(Chimpanzee().info(), "wt: 100.0 age: 12")
            assertEquals(BonoboB().info(), "wt: 100.0 age: 12")
        }
    }

    @Test
    fun testGreatApe() {
    // Cannot access 'energy':
    // GreatApe().energy
        val greatApe = org.example.inheritance.complex.GreatApe()
        assertEquals(greatApe.talk(org.example.inheritance.complex.GreatApe()), "Hoo! Energy: 0")
        assertEquals(greatApe.talk(org.example.inheritance.complex.Bonobo()), "Eep! Energy: 10")
        assertEquals(greatApe.talk(org.example.inheritance.complex.Chimpanzee()), "Yawp! Energy: 20")
    }
}