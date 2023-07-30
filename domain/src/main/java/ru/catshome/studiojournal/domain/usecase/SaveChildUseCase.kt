package ru.catshome.studiojournal.domain.usecase

import ru.catshome.studiojournal.domain.models.Child
import ru.catshome.studiojournal.domain.repository.ChildRepository


class SaveChildUseCase (private val childLocalRepository: ChildRepository) {
    suspend fun save(child: Child)
    {
       // if (child?.childName?.isEmpty())
       //     return

        return childLocalRepository.saveChild(child)

    }
}