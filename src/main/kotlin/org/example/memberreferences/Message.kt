package org.example.memberreferences

import kotlin.coroutines.coroutineContext

data class Message(
    val sender : String,
    val text : String,
    val isRead : Boolean,
    val attachments: List<Attachment>
) {
}

data class Attachment(
    val type: String,
    val name: String
)

fun Message.isImportant(): Boolean =
    text.contains("Salary increase") ||
            attachments.any {
                it.type == "image" &&
                        it.name.contains("cat")
            }

fun ignore(message: Message) = !message.isImportant() && message.sender in setOf("Boss", "Mom")