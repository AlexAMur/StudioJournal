package ru.catshome.studiojournal.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.catshome.studiojournal.domain.models.Child
import ru.catshome.studiojournal.domain.repository.ChildRepository


class LoadChildUseCase (private val repositoryChild: ChildRepository){
    suspend fun loadAllChilds():Flow<List<Child>>{
        return repositoryChild.loadAllChild()
    }
    suspend fun loadChildByGroup( uid_group: Long):Flow<List<Child>>{
        return repositoryChild.loadChildByGroup(uid_group = uid_group)
    }

    suspend fun loadChildById(uid: Long): Flow<Child> {
        return repositoryChild.loadChildByID(uid = uid)
    }

}