package ru.catshome.studiojournal.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Child

interface ChildRepository {
    suspend fun saveChild(child: Child)
    fun removeChild(child: Child)
    fun loadChildByID(uid :Long): Flow<Child>
    fun loadChildByGroup(uid_group: Long): Flow<List<Child>>
    suspend fun loadAllChild(): Flow<List<Child>>
}
