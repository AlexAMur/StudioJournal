package ru.catshome.studiojournal.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Child

interface ChildRepository {
    fun saveChild(child: Child)
    fun removeChild()
    fun loadChildByID(uid :Long): Flow<Child>
    fun loadChildByGroup(uid: Long): Flow<List<Child>>
    suspend fun loadAllChild(): Flow<List<Child>>
}
