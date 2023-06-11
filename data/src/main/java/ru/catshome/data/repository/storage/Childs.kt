package ru.catshome.data.repository.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Childs(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "fam") val childFam: String,
    @ColumnInfo(name = "name") val childName: String,
    @ColumnInfo(name = "birth") val childBirth: Long,
    @ColumnInfo(name = "note") val childNote: String,

)

