package ru.catshome.studiojournal.domain.models

data class Child (
    val uid: Long =-1,
    val childFam: String?="",
    val childName: String,
    val brith: Long = 0,
    val Note: String?="",
    )
