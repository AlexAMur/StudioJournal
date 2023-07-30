package ru.catshome.data.repository.storage.room.DAO

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.catshome.data.repository.storage.room.entity.GroupEntity
import ru.catshome.studiojournal.domain.models.Child
import ru.catshome.studiojournal.domain.models.Group

@Dao
interface GroupDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: GroupEntity)
    @Delete
    fun deleteChild(vararg groups: GroupEntity)
    @Query("Select * from groups ")
    fun loadAllGroup(): Flow<List<GroupEntity>>

    @Query("Select * from groups where uid = :uid")
    fun loadGroupByID(uid: Long): Flow<List<GroupEntity>>
}