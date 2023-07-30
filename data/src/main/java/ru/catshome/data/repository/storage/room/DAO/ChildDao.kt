package ru.catshome.data.repository.storage.room.DAO

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.catshome.data.repository.storage.room.entity.ChildEntity
import ru.catshome.studiojournal.domain.models.Child

@Dao
interface ChildDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertChild(child: ChildEntity)
    @Delete
    fun deleteChild(vararg childs: ChildEntity)
    @Query("Select * from children")
    fun loadAllChild(): Flow<List<ChildEntity>>

    @Query("Select * from children where uid = :uid")
    fun loadChildByID(uid: Long): Flow<ChildEntity>

    @Query("Select * from children where uid = :uid_group")
    fun loadChildByGroup(uid_group: Long): Flow<List<ChildEntity>>}