package org.example.lambdas

import org.example.extensionproperties.indices
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LambdasTest {
    @Test
    fun basicLambdaTest() {
        val list = listOf(1, 2, 3, 4)
        val result = list.map({ n: Int -> "[$n]" })
        assertEquals(result, listOf("[1]", "[2]", "[3]", "[4]"))
    }

    @Test
    fun basicLambdaTypeInferenceTest() {
        val list = listOf(1, 2, 3, 4)
        val result = list.map({ n -> "[$n]" })
        assertEquals(result, listOf("[1]", "[2]", "[3]", "[4]"))
    }

    @Test
    fun lambdaItTest() {
        val list = listOf(1, 2, 3, 4)
        val result = list.map({ "[$it]" })
        assertEquals(result, listOf("[1]", "[2]", "[3]", "[4]"))
    }

    @Test
    fun testMapping() {
        val list = listOf('a', 'b', 'c', 'd')
        val result = list.map { "[${it.uppercase()}]" }
        assertEquals(result, listOf("[A]", "[B]", "[C]", "[D]"))
    }

    @Test
    fun joinToStringTest() {
        val list = listOf(9, 11, 23, 32)
        assertEquals(list.joinToString(" ") { "[$it]" }, "[9] [11] [23] [32]")
    }

    @Test
    fun testLambdaAndNamedArgs() {
        val list = listOf(9, 11, 23, 32)
        assertEquals(list.joinToString(
            separator = " ",
            transform = { "[$it]" }
        ), "[9] [11] [23] [32]")
    }

    @Test
    fun testTwoArgLambda() {
        val list = listOf('a', 'b', 'c')
        assertEquals(list.mapIndexed { index, element ->
            "[$index: $element]"
        }, listOf("[0: a]", "[1: b]", "[2: c]"))
    }

    @Test
    fun testUnderscore() {
        val list = listOf('a', 'b', 'c')
        assertEquals(list.mapIndexed { index, _ ->
            "[$index]"
        }, listOf("[0]", "[1]", "[2]"))
    }

    @Test
    fun testListIndicesMap(){
        val list = listOf('a', 'b', 'c')
        assertEquals( list.indices.map { "[$it]" }, listOf("[0]", "[1]", "[2]"))
    }

    @Test
    fun filteringBasicTest() {
        val list = listOf(1, 2, 3, 4)
        val even = list.filter { it % 2 == 0 }
        val greaterThan2 = list.filter { it > 2 }
        assertEquals( even, listOf(2, 4))
        assertEquals( greaterThan2, listOf(3, 4))
    }

    @Test
    fun testStoringLambdaInVal() {
        val list = listOf(1, 2, 3, 4)
        val isEven = { e: Int -> e % 2 == 0 }
        assertEquals(list.filter(isEven), listOf(2, 4))
        assertEquals(list.any(isEven), true)
    }

    @Test
    fun closureTest(){
        val list = listOf(1, 5, 7, 10)
        val divider = 5
        assertEquals(list.filter { it % divider == 0 }, listOf(5, 10))
    }

    @Test
    fun closureWithVarTest() {
        val list = listOf(1, 5, 7, 10)
        var sum = 0
        val divider = 5
        list.filter { it % divider == 0 }.forEach { sum += it }
        assertEquals(sum, 15)
    }

    @Test
    fun sumTest() {
        val list = listOf(1, 5, 7, 10)
        val divider = 5
        val sum = list.filter { it % divider == 0 }.sum()
        assertEquals(sum, 15)
    }

    var x = 100
    fun useX() {
        x++
    }

    @Test
    fun testFunctionClosure() {
        useX()
        assertEquals(x, 101)
    }
}