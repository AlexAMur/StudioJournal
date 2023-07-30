package ru.catshome.studiojournal.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Group

interface GroupRepository {
    suspend fun save(group: Group)
    suspend fun loadByUid(): Flow<Group>
    suspend fun loadAll():Flow<List<Group>>
}