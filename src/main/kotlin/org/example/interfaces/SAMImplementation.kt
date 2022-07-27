package org.example.interfaces

class VerboseZero : ZeroArg {
    override fun f() = 11
}

val verboseZero = VerboseZero()

val samZero = ZeroArg { 11 }

class VerboseOne: OneArg {
    override fun g(n: Int) = n + 47
}

val verboseOne = VerboseOne()
val samOne = OneArg { it + 47 }

class VerboseTwo : TwoArg {
    override fun h(i: Int, j: Int) = i + j
}
val verboseTwo = VerboseTwo()
val samTwo = TwoArg { i, j -> i + j }