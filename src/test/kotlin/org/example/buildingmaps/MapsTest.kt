package org.example.buildingmaps

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MapsTest {
    @Test
    fun testGroupBy(){
        val map: Map<Int, List<Person>> = people().groupBy(Person::age)
        assertEquals(map[15], listOf(Person("Arthricia", 15)))
        assertEquals(map[21], listOf(
            Person("Alice", 21),
            Person("Charlie", 21),
            Person("Franz", 21)))
        assertEquals(map[22], null)
        assertEquals(map[25], listOf(
            Person("Bob", 25),
            Person("Bill", 25)))
        assertEquals(map[33], listOf(Person("Revolio", 33)))
        assertEquals(map[42], listOf(
            Person("Birdperson", 42),
            Person("Crocubot", 42)))
    }

    @Test
    fun testGroupByVsFilter(){
        val groups = people().groupBy { it.name.first() }
        assertEquals(groups['A'], listOf(Person("Alice", 21), Person("Arthricia", 15)))
        assertEquals(groups['A'], listOf(Person("Alice", 21),
            Person("Arthricia", 15)))
        assertEquals(groups['Z'], null)

        assertEquals(people().filter { it.name.first() == 'A' }, listOf(Person("Alice", 21), Person("Arthricia", 15)))
        assertEquals(people().filter { it.name.first() == 'F' }, listOf(Person("Franz", 21)))
        assertEquals(people().partition { it.name.first() == 'A' }, Pair(
            listOf(Person("Alice", 21),
                Person("Arthricia", 15)),
            listOf(Person("Bob", 25),
                Person("Bill", 25),
                Person("Birdperson", 42),
                Person("Charlie", 21),
                Person("Crocubot", 42),
                Person("Franz", 21),
                Person("Revolio", 33))))
    }

    @Test
    fun testAssociateWith() {
        val map: Map<Person, String> =
            people().associateWith { it.name }
        assertEquals(map , mapOf(
            Person("Alice", 21) to "Alice",
            Person("Arthricia", 15) to "Arthricia",
            Person("Bob", 25) to "Bob",
            Person("Bill", 25) to "Bill",
            Person("Birdperson", 42) to "Birdperson",
            Person("Charlie", 21) to "Charlie",
            Person("Crocubot", 42) to "Crocubot",
            Person("Franz", 21) to "Franz",
            Person("Revolio", 33) to "Revolio"))
    }

    @Test
    fun testAssociateBy() {
        val map: Map<String, Person> =
            people().associateBy { it.name }
        assertEquals(map, mapOf(
            "Alice" to Person("Alice", 21),
            "Arthricia" to Person("Arthricia", 15),
            "Bob" to Person("Bob", 25),
            "Bill" to Person("Bill", 25),
            "Birdperson" to Person("Birdperson", 42),
            "Charlie" to Person("Charlie", 21),
            "Crocubot" to Person("Crocubot", 42),
            "Franz" to Person("Franz", 21),
            "Revolio" to Person("Revolio", 33)))
    }

    @Test
    fun testAssociateByKeyIsNotUnique() {
        // associateBy() fails when the key isn't
        // unique -- values disappear:
        val ages = people().associateBy { it.age }
        assertEquals(
            ages, mapOf(
                21 to Person("Franz", 21),
                15 to Person("Arthricia", 15),
                25 to Person("Bill", 25),
                42 to Person("Crocubot", 42),
                33 to Person("Revolio", 33)
            )
        )
    }

    @Test
    fun testGetOrPut() {
        val map = mapOf(1 to "one", 2 to "two")
        assertEquals(map.getOrElse(0) { "zero" }, "zero")
        val mutableMap = map.toMutableMap()
        assertEquals( mutableMap.getOrPut(0) { "zero" } , "zero")
        assertEquals(mutableMap.toString(), "{1=one, 2=two, 0=zero}")
    }

    @Test
    fun testFilterMap() {
        val map = mapOf(1 to "one",
            2 to "two", 3 to "three", 4 to "four")
        assertEquals(map.filterKeys { it % 2 == 1 }, mapOf(1 to "one", 3 to "three"))
        assertEquals( map.filterValues { it.contains('o') }, mapOf(1 to "one", 2 to "two", 4 to "four"))
        assertEquals(map.filter { entry ->
            entry.key % 2 == 1 &&
                    entry.value.contains('o')
        }, mapOf(1 to "one"))
    }

    @Test
    fun testTransformingMap(){
        val even = mapOf(2 to "two", 4 to "four")
        assertEquals( even.map { "${it.key}=${it.value}" }, listOf("2=two", "4=four"))

        assertEquals(even.map { (key, value) -> "$key=$value" }, listOf("2=two", "4=four"))
        assertEquals(even.mapKeys { (num, _) -> -num }.mapValues { (_, str) -> "minus $str" }, mapOf(-2 to "minus two", -4 to "minus four"))
        assertEquals(even.map { (key, value) -> -key to "minus $value" }.toMap(), mapOf(-2 to "minus two", -4 to "minus four"))
    }

    fun testSimilarOperation() {
        val map = mapOf(1 to "one", -2 to "minus two")
        assertEquals(map.any { (key, _) -> key < 0 }, true)
        assertEquals(map.all { (key, _) -> key < 0 }, false)
        assertEquals(map.maxByOrNull { it.key }?.value, "one")
    }
}