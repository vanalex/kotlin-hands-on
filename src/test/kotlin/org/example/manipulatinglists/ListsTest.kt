package org.example.manipulatinglists

import org.junit.jupiter.api.Test
import javax.swing.AbstractCellEditor
import kotlin.random.Random
import kotlin.test.assertEquals

class ListsTest {
    @Test
    fun testZipper() {
        val left = listOf("a", "b", "c", "d")
        val right = listOf("q", "r", "s", "t")
        assertEquals(left.zip(right),
                listOf(Pair("a", "q"), Pair("b", "r"), Pair("c", "s"), Pair("d", "t")))
        assertEquals(left.zip(0..4),
                listOf(Pair("a", 0), Pair("b", 1), Pair("c", 2), Pair("d", 3)))
    }

    @Test
    fun testZipAndTransformation(){
        val names = listOf("Bob", "Jill", "Jim")
        val ids = listOf(1731, 9274, 8378)
        val expected = listOf(Person("Bob", 1731), Person("Jill", 9274), Person("Jim", 8378))
        assertEquals( names.zip(ids) { name, id -> Person(name, id) }, expected)
    }

    @Test
    fun test0ZippingWithNext(){
        val list = listOf('a', 'b', 'c', 'd')
        val expected = listOf(Pair('a', 'b'), Pair('b', 'c'), Pair('c', 'd'))
        assertEquals(list.zipWithNext(), expected)
    }

    @Test
    fun testFlatten() {
        val list = listOf(
            listOf(1, 2),
            listOf(4, 5),
            listOf(7, 8),
        )
        assertEquals(list.flatten(), listOf(1, 2, 4, 5, 7, 8))
    }

    @Test
    fun testFlattenAndFlatMap(){
        val intRange = 1..3
        val expectedFlattened = listOf(Pair(1, 1), Pair( 1, 2), Pair(1, 3), Pair(2, 1), Pair(2, 2), Pair(2, 3), Pair(3, 1), Pair(3, 2), Pair(3, 3))
        val expectedUnflattened = listOf(listOf(Pair(1, 1), Pair( 1, 2), Pair(1, 3)), listOf(Pair(2, 1), Pair(2, 2), Pair(2, 3)), listOf(Pair(3, 1), Pair(3, 2), Pair(3, 3)))

        assertEquals( intRange.map { a ->
            intRange.map { b -> a to b }
        }, expectedUnflattened)
        assertEquals( intRange.map { a ->
            intRange.map { b -> a to b }
        }.flatten(), expectedFlattened)

        assertEquals( intRange.flatMap { a ->
            intRange.map { b -> a to b }
        }, expectedFlattened)
    }

    @Test
    fun testFlatMap() {
        val books = listOf(
            Book("1984", listOf("George Orwell")),
            Book("Ulysses", listOf("James Joyce"))
        )
        assertEquals(books.map { it.authors }.flatten() , listOf("George Orwell", "James Joyce"))
        assertEquals(books.flatMap { it.authors } , listOf("George Orwell", "James Joyce"))
    }
}