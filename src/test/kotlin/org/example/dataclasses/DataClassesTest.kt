package org.example.dataclasses

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class DataClassesTest {

    @Test
    fun testSimpleDataClass() {
        val s1 = Simple("Hi", 29)
        val s2 = Simple("Hi", 29)
        assertEquals(s1.toString(), "Simple(arg1=Hi, arg2=29)")
        assertEquals(s1, s2)
    }

    @Test
    fun testDataClasses() {
        // These seem the same, but they're not:
        assertNotEquals(Person("Cleo"), Person("Cleo"))
        // A data class defines equality sensibly:
        assertEquals(Contact("Miffy", "1-234-567890"), Contact("Miffy", "1-234-567890"))
    }

    @Test
    fun testCopyDataClass() {
        val contact = DetailedContact(
            "Miffy",
            "Miller",
            "1-234-567890",
            "1600 Amphitheatre Parkway"
        )
        val newContact = contact.copy(
            number = "098-765-4321",
            address = "Brandschenkestrasse 110"
        )
        assertEquals(newContact, DetailedContact(
            "Miffy",
            "Miller",
            "098-765-4321",
            "Brandschenkestrasse 110")
        )

    }

    @Test
    fun testHashCode() {
        val korvo: Key = Key("Korvo", 19)
        assertEquals(korvo.hashCode(), -2041757108)
        val map = HashMap<Key, String>()
        map[korvo] = "Alien"
        assertEquals(map[korvo], "Alien")
        val set = HashSet<Key>()
        set.add(korvo)
        assertEquals(set.contains(korvo), true)
    }
}