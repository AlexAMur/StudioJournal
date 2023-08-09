package ru.catshome.studiojournal.domain.usecase

import ru.catshome.studiojournal.domain.models.Group
import ru.catshome.studiojournal.domain.repository.GroupRepository


class SaveGroupUseCase (private val saveGroupRepository: GroupRepository) {
   suspend fun save(group: Group){
        saveGroupRepository.save(group)
    }
}