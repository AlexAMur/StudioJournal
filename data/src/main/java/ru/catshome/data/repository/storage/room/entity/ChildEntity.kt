package ru.catshome.data.repository.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChildEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "fam") val childFam: String?,
    @ColumnInfo(name = "name") val childName: String,
    @ColumnInfo(name = "birth") val childBirth: Long?,
    @ColumnInfo(name = "note") val childNote: String?,

)

