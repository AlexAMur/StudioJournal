package ru.catshome.data.repository.storage.room.DAO

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Child

@Dao
interface ChildDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertChild(child: Child)
    @Delete
    fun deleteChild(vararg childs: Child)
    @Query("Select * from ")
    fun loadAllChild(): Flow<List<Child>>

    @Query("Select * from  ")
    fun loadChildByID(): Flow<List<Child>>
}