package org.example.visibility

class Counter(var start: Int) {
    fun increment(){
        start += 1
    }

    override fun toString(): String {
        return start.toString()
    }
}

class CounterHolder(counter: Counter){
    private val ctr = counter

    override fun toString(): String {
        return "CounterHolder: " + ctr
    }
}

fun main(){
    val c = Counter(11)
    val ch = CounterHolder(c)
    println(ch)
    c.increment()
    println(ch)
    val ch2 = CounterHolder(Counter(9))
    println(ch2)
}