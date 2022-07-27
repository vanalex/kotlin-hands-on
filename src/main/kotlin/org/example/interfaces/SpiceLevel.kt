package org.example.interfaces

enum class SpiceLevel : Hotness{
    Mild{
        override fun feedback() = "It adds flavor!"
    },
    Medium {
        override fun feedback() =
            "Is it warm in here?"
    },
    Hot {
        override fun feedback() =
            "I'm suddenly sweating a lot."
    },
    Flaming {
        override fun feedback() =
            "I'm in pain. I am suffering."
    }
}