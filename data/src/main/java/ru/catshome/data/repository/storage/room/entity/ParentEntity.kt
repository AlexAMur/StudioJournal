package ru.catshome.data.repository.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParentEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "child_uid") val childUid: Long,
    @ColumnInfo(name = "parent_fam") val famParent: String?,
    @ColumnInfo(name = "parent_name") val nameParent: String,
    @ColumnInfo(name = "parent_pone") val phoneParent: String?,
)