package org.example.namedarguments

class DefaultArg {}

fun h(d: DefaultArg = DefaultArg()) = println(d)