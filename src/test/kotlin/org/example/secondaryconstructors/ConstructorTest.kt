package org.example.secondaryconstructors

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConstructorTest {

    @Test
    fun basicTest(){
        fun sep() = println("-".repeat(10))
        WithSecondary(1)
        sep()
        WithSecondary('D')
        sep()
        WithSecondary("Last Constructor")
    }

    @Test
    fun testSeveralConstructors() {
        assertEquals(GardenItem("Elf").material, Material.Plastic)
        assertEquals(GardenItem("Snowman").name, "Snowman")
        assertEquals(GardenItem("Gazing Ball", Material.Metal).toString(), "Metal Gazing Ball")
        assertEquals(GardenItem(material = Material.Ceramic).toString(), "Ceramic Strange thing")
    }
}