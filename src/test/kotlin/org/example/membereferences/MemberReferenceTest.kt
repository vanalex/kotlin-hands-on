package org.example.membereferences

import org.example.memberreferences.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MemberReferenceTest {
    @Test
    fun testBasic(){
        val messages = listOf(
            Message("Kitty", "Hey!", true, listOf()),
            Message("Kitty", "Where are you?", false, listOf()))

        val unread = messages.filterNot(Message::isRead)
        assertEquals(unread.size,1)
        assertEquals(unread.single().text, "Where are you?")
    }

    @Test
    fun testSortedWith(){
        val messages = listOf(
            Message("Kitty", "Hey!", true, listOf()),
            Message("Kitty", "Where are you?", false, listOf()),
            Message("Boss", "Meeting today", false, listOf()))

        val sortedList = messages.sortedWith(compareBy(Message::isRead, Message::sender))
        assertEquals(sortedList, listOf(Message("Boss", "Meeting today", false, listOf()), Message("Kitty", "Where are you?", false, listOf()), Message("Kitty", "Hey!", true, listOf())))
    }

    @Test
    fun testFunctionReference() {
        val messages = listOf(Message(
            "Boss", "Let's discuss goals " +
                    "for next year", false,
            listOf(Attachment("image", "cute cats"))))
        assertEquals(messages.any(Message::isImportant), true)
    }

    @Test
    fun testTopLevelFunctionReference() {
        val text = "Let's discuss goals " +
                "for the next year"
        val msgs = listOf(
            Message("Boss", text, false, listOf()),
            Message("Boss", text, false, listOf(
                Attachment("image", "cute cats"))))
        assertEquals(msgs.filter(::ignore).size, 1)
        assertEquals(msgs.filterNot(::ignore).size, 1)
    }

    @Test
    fun testConstructorReference(){
        val names = listOf("Alice", "Bob")
        val students = names.mapIndexed{index, name -> Student(index, name)}
        assertEquals(students, listOf(Student(0, "Alice"), Student(1, "Bob")))
        assertEquals(names.mapIndexed(::Student), students)
    }

    @Test
    fun testExtensionReference() {
        assertEquals(goInt(12, Int::times47), 564)
        assertEquals(goFrog(Frog(), Frog::speak), "Ribbit!")
    }
}