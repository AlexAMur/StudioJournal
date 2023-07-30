package ru.catshome.data.repository.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class VisitEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "child_uid") val childUid: Long,
    @ColumnInfo(name = "data_visit") val dataVisit: Long,
    @ColumnInfo(name = "lesson_cost") val lessonCost: Double,
)
