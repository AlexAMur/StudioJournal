package ru.catshome.studiojournal.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Group
import ru.catshome.studiojournal.domain.repository.GroupRepository

class LoadGroupUseCase(private val repository: GroupRepository) {
    suspend fun loadAllGroup(): Flow<List<Group>>{
        return repository.loadAll()
    }
}