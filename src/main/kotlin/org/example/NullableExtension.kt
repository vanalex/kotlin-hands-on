package org.example

fun String?.isNullOrEmpty(): Boolean =
    this == null || isEmpty()