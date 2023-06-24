package ru.catshome.studiojournal.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Child

interface ChildRepository {
    fun saveChild(child: Child)
    fun removeChild()
    fun loadChildByID()
    fun loadChildByGroup()
    suspend fun loadAllChild(): Flow<List<Child>>
}
