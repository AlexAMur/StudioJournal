package ru.catshome.data.repository.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TarifEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "tarif_name") val tarifName: String,
    @ColumnInfo(name = "tarif") val tarif: Double,

)