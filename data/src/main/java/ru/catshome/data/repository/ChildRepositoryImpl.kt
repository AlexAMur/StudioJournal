package ru.catshome.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.catshome.data.repository.storage.room.DAO.ChildDao
import ru.catshome.data.repository.storage.room.entity.ChildEntity
import ru.catshome.studiojournal.domain.models.Child
import ru.catshome.studiojournal.domain.repository.ChildRepository
import javax.inject.Inject
fun Child.mapToEntity(): ChildEntity {
    return ChildEntity(uid = this.uid,
                        childFam = this.childFam,
                        childName =this.childName,
                        childBirth = this.birth,
                        childNote = this.note)
}
fun ChildEntity.mapToChild(): Child {
    return Child(uid = this.uid,
        childFam = this.childFam?:"",
        childName =this.childName?:"",
        birth = this.childBirth?:0,
        note = this.childNote?:"")
}


class ChildRepositoryImpl @Inject constructor(private val childDao: ChildDao): ChildRepository {
    override suspend fun saveChild(child: Child){
        childDao.insertChild(child.mapToEntity())

    }

    override fun removeChild(child: Child) {
        childDao.deleteChild(child.mapToEntity())
    }

    override fun loadChildByID(uid: Long): Flow<Child> {
       return childDao.loadChildByID(uid = uid).map {
           it.mapToChild()
       }
    }

    override fun loadChildByGroup(uid_group: Long): Flow<List<Child>> {
        return childDao.loadChildByGroup(uid_group = uid_group).map {childList->
            childList.map {
                it.mapToChild()
            }
        }
    }

    override suspend fun loadAllChild(): Flow<List<Child>> {
        return  childDao.loadAllChild().map {childList->
            childList.map{
                it.mapToChild()
            }
        }
    }
}