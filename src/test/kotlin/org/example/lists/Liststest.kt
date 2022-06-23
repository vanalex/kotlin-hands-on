package org.example.lists

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Liststest {

    @Test
    fun testListCreation(){
        val integers = listOf(2, 4, 10, 12, 9, 7)
        assertEquals(integers, listOf(2, 4, 10, 12, 9, 7))
    }

    @Test
    fun testConcatListElements(){
        val integers = listOf(2, 4, 10, 12, 9, 7)
        var result = ""
        for (i in integers) {
            result += "$i "
        }

        assertEquals("2 4 10 12 9 7 ", result)
    }

    @Test
    fun testSumListElements(){
        val integers = listOf(2, 4, 10, 12, 9, 7)

        assertEquals(44, integers.sum())
    }

    @Test
    fun testOutOfBoundsList(){
        val integers = listOf(3, 6, 8)
        try{
           integers.get(3)
        }catch (exception: ArrayIndexOutOfBoundsException){
            assertEquals("Index 3 out of bounds for length 3", exception.localizedMessage)
        }
    }

    @Test
    fun testSumElementOfList(){
        val doubles = listOf(1.1, 2.2, 3.3, 4.4)
        assertEquals(doubles.sum(), 11.0)
    }

    @Test
    fun testOperationsOnListOfString(){
        val strings = listOf("Twas", "Brillig", "And", "Slithy", "Toves")
        assertEquals(strings, listOf("Twas", "Brillig", "And", "Slithy", "Toves"))
        assertEquals(strings.sorted(), listOf("And", "Brillig", "Slithy", "Toves", "Twas"))
        assertEquals(strings.reversed(), listOf("Toves", "Slithy", "And", "Brillig", "Twas"))
        assertEquals(strings.first(),"Twas")
        assertEquals(strings.takeLast(2), listOf("Slithy", "Toves"))
    }

    data class Person(val name: String, val age: Int, val driversLicense: Boolean = false)

    val friendsGroup = listOf(
        Person("Jo", 19),
                            Person("Mic", 15),
                            Person("Hay", 33, true),
                            Person("Cal", 25)
    )

    @Test
    fun testCollectionOperations(){
        assertTrue(friendsGroup.any{it.driversLicense})
        assertFalse(friendsGroup.none { it.age < 18 })
        assertTrue(friendsGroup.all { it.name.length < 4 })

        val emptyPersonList = emptyList<Person>()
        assertFalse(emptyPersonList.any { it.driversLicense })
        assertTrue(emptyPersonList.none { it.age < 18 })
        assertTrue(emptyPersonList.all { it.name.count() < 4 })

        val lettersInNames = listOf("Lou", "Mel", "Cyn").flatMap { it.toList() }
        assertEquals(listOf('L', 'o', 'u', 'M','e','l', 'C', 'y', 'n'), lettersInNames)
    }

    // Return type is inferred:
    fun inferred(p: Char, q: Char) =
        listOf(p, q)
    // Explicit return type:
    fun explicit(p: Char, q: Char): List<Char> =
        listOf(p, q)

    @Test
    fun parameterizedTest(){
        val numbers = listOf(1, 2, 3)
        val numbersAsStrings = listOf("One", "Two", "Three")
        val numbers2 = listOf<Int>(1, 2, 3)
        val numbersAsStrings2 = listOf<String>("One", "Two", "Three")
        assertEquals(numbers, numbers2)
        assertEquals(numbersAsStrings, numbersAsStrings2)
        assertEquals(inferred('a', 'b'), listOf('a', 'b'))
        assertEquals(explicit('y', 'z'), listOf('y', 'z'))
    }

    fun getList(): List<Int> {
        return mutableListOf(1, 2, 3)
    }

    @Test
    fun mutableListTest(){
        val list = mutableListOf<Int>()
        list.add(1)
        list.addAll(listOf(2, 3))
        list += 4
        list += listOf(5, 6)
        assertEquals(list, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun mutListIsListTest(){
        // getList() produces a read-only List:
        val list = getList()
        // list += 3 // Error
        assertEquals(list, listOf(1, 2, 3))
    }

    @Test
    fun multipleListRefsTest(){
        val first = mutableListOf(1)
        val second: List<Int> = first
        assertEquals( second, listOf(1))
        first += 2
        // second sees the change:
        assertEquals(second, listOf(1, 2))
    }

    @Test
    fun testZip(){
        val germanCities = listOf(
            "Aachen",
            "Bielefeld",
            "München"
        )

        val germanLicensePlates = listOf(
            "AC",
            "BI",
            "M"
        )
        val aachen = Pair("Aachen", "AC")
        val bielefeld = Pair("Bielefeld", "BI")
        val muenchen = Pair("München", "M")

        val result = arrayListOf(aachen, bielefeld, muenchen)
        assertEquals(germanCities.zip(germanLicensePlates), result)
    }
}