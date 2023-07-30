package ru.catshome.studiojournal.domain.models

data class Child (
    val uid: Long =0,
    var childFam: String="",
    var childName: String ="",
    val birth: Long = 0,
    var note: String="",
    )
