package org.example.localfunction

import org.example.localfunctions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LocalFunctionTest {
    @Test
    fun testBasicLocalFunction() {
        val expected = StringBuilder().appendLine("Starting computation").appendLine("Computation result: 42")
        val logMsg = StringBuilder()
        fun log(message: String) =
            logMsg.appendLine(message)
        log("Starting computation")
        val x = 42 // Imitate computation
        log("Computation result: $x")
        assertEquals(logMsg.toString(), expected.toString())
    }

    @Test
    fun testLocalExtensions() {
        assertEquals("Hello".exclaim(), "Hello!")
        assertEquals("Hallo".exclaim(), "Hallo!")
        assertEquals("Bonjour".exclaim() , "Bonjour!")
        assertEquals("Ciao".exclaim(), "Ciao!")
    }

    fun testLocalFunctionReference() {
        fun interesting(session: Session): Boolean {
            if (session.title.contains("Kotlin") &&
                session.speaker in favoriteSpeakers
            ) {
                return true
            }
            return false
        }
        assertEquals(sessions.any(::interesting), true)
    }

    @Test
    fun testInterestingSession() {
        assertEquals(sessions.any(
            fun(session: Session): Boolean {
                if (session.title.contains("Kotlin") &&
                    session.speaker in favoriteSpeakers
                ) {
                    return true
                }
                return false
            }), true
        )
    }

    @Test
    fun testLabelReturn() {
        val list = listOf(1, 2, 3, 4, 5)
        val value = 3
        var result = ""
        list.forEach {
            result += "$it"
            if (it == value) return@forEach
        }
        assertEquals(result , "12345")
    }

    @Test
    fun testCustomLabel() {
        val list = listOf(1, 2, 3, 4, 5)
        val value = 3
        var result = ""
        list.forEach tag@{
            result += "$it"
            if (it == value) return@tag
        }
        assertEquals(result, "12345")
    }

    @Test
    fun testReturnInsideLambda() {
        assertEquals( sessions.any { session ->
            if (session.title.contains("Kotlin") &&
                session.speaker in favoriteSpeakers) {
                return@any true
            }
            false
        }, true)
    }

    @Test
    fun testReturnFunction() {
        val funRef1: (Int) -> Int = first()
        val funRef2: (String) -> String = second()
        val funRef3: () -> String = third()
        val funRef4: () -> String = fourth()
        val funRef5: () -> String = fifth()
        assertEquals(funRef1(42), 43)
        assertEquals(funRef2("xyz"), "xyz!")
        assertEquals(funRef3(), "Hi!")
        assertEquals(funRef4(), "Hi!")
        assertEquals(funRef5(), "Hi!")
        assertEquals(first()(42), 43)
        assertEquals(second()("xyz"), "xyz!")
        assertEquals(third()(), "Hi!")
        assertEquals(fourth()(), "Hi!")
        assertEquals(fifth()(), "Hi!")
    }
}