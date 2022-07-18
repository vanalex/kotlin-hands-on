package org.example.lambdas

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OperationsTest {

    @Test
    fun createListTest(){
        val list1 = List(10){it}
        assertEquals(list1, listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))

        val list2 = List(10) { 0 }
        assertEquals(list2, listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        val list3 = List(10) { 'a' + it }
        assertEquals(list3, listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'))

        val list4 = List(10) { list3[it % 3] }
        assertEquals(list4, listOf('a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'c', 'a'))
    }

    @Test
    fun testListInit() {
        val mutableList1 = MutableList(5, { 10 * (it + 1) })
        assertEquals(mutableList1, listOf(10, 20, 30, 40, 50))
        val mutableList2 = MutableList(5) { 10 * (it + 1) }
        assertEquals(mutableList2, listOf(10, 20, 30, 40, 50))
    }

    @Test
    fun testFilterNotNull(){
        val list = listOf(1, null, 2, null, 3, null, 4, null)
        val result = list.filterNotNull()
        assertEquals(result, listOf(1, 2, 3, 4))
    }

    @Test
    fun testByFunctions(){
        val products = listOf(
            Product("bread", 2.0),
            Product("wine", 5.0)
        )
        assertEquals(products.sumOf { it.price }, 7.0)
        assertEquals(products.sortedByDescending { it.price }, listOf(Product("wine", 5.0), Product("bread", 2.0)))
        assertEquals(products.minByOrNull { it.price }, Product("bread", 2.0))
    }

    @Test
    fun testTakeOrDrop() {
        val list = listOf('a', 'b', 'c', 'X', 'Z')
        assertEquals(list.takeLast(3), listOf('c', 'X', 'Z'))
        assertEquals(list.takeLastWhile { it.isUpperCase() }, listOf('X', 'Z'))
        assertEquals(list.drop(1), listOf('b', 'c', 'X', 'Z'))
        assertEquals(list.dropWhile { it.isLowerCase() }, listOf('X', 'Z'))
    }

    @Test
    fun testOnSetOperations() {
        val set = setOf("a", "ab", "ac")
        assertEquals(set.maxByOrNull { it.length }?.length, 2)
        assertEquals(set.filter {
            it.contains('b')
        }, listOf("ab"))
        assertEquals(set.map { it.length }, listOf(1, 2, 2))
    }
}