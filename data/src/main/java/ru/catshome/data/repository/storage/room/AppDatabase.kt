package ru.catshome.data.repository.storage.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import ru.catshome.data.repository.storage.room.DAO.ChildDao
import ru.catshome.data.repository.storage.room.DAO.GroupDao
import ru.catshome.data.repository.storage.room.entity.ChildEntity
import ru.catshome.data.repository.storage.room.entity.GroupEntity

@Database(entities = [ GroupEntity::class, ChildEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun childDao(): ChildDao
    abstract fun groupDao(): GroupDao


}