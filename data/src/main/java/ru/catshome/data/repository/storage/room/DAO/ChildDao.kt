package ru.catshome.data.repository.storage.room.DAO

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.catshome.data.repository.storage.room.entity.ChildEntity
import ru.catshome.studiojournal.domain.models.Child

@Dao
interface ChildDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertChild(child: Child)
    @Delete
    fun deleteChild(vararg childs: Child)
    @Query("Select * from childs ")
    fun loadAllChild(): Flow<List<Child>>

    @Query("Select * from childs where uid = :uid")
    fun loadChildByID(uid: Long): Flow<List<Child>>
}