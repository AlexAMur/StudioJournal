package ru.catshome.data.repository

import kotlinx.coroutines.flow.Flow
import ru.catshome.data.repository.storage.room.DAO.ChildDao
import ru.catshome.studiojournal.domain.models.Child
import ru.catshome.studiojournal.domain.repository.ChildRepository
import javax.inject.Inject


class ChildRepositoryImpl @Inject constructor(val childDao: ChildDao): ChildRepository {
    override fun saveChild(child: Child) {
        childDao.insertChild(child)
    }

    override fun removeChild() {
        TODO("Not yet implemented")
    }

    override fun loadChildByID() {
        TODO("Not yet implemented")
    }

    override fun loadChildByGroup() {
        TODO("Not yet implemented")
    }

    override suspend fun loadAllChild(): Flow<List<Child>> {
        return  childDao.loadAllChild()
    }
}