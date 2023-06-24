package ru.catshome.data.repository.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.catshome.data.repository.storage.room.DAO.ChildDao
import ru.catshome.data.repository.storage.room.entity.ChildEntity

@Database(entities = [ChildEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun childDao():ChildDao
}