package ru.catshome.data.repository.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PayEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "child_uid") val childUid: Long,
    @ColumnInfo(name = "data_pay") val dataPay: Long,
    @ColumnInfo(name = "pay") val pay: Double,
)
