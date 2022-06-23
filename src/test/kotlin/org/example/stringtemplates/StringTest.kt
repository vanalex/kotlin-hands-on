package org.example.stringtemplates

import kotlin.test.Test
import kotlin.test.assertEquals

class StringTest {

    @Test
    fun concatTest(){
        val s = "hi/n"
        val number = 11
        val decimal = 3.14
        val result = "first: $s second:$number third: $decimal"
        assertEquals("first: hi/n second:11 third: 3.14", result)
    }

    @Test
    fun printStringTemplateTest(){
        val answer = 42
        assertEquals("Found 42!", "Found $answer!")
    }
}