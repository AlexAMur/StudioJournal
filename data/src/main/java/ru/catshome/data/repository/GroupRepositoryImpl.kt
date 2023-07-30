package ru.catshome.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.catshome.data.repository.storage.room.DAO.GroupDao
import ru.catshome.data.repository.storage.room.entity.GroupEntity
import ru.catshome.studiojournal.domain.models.Group
import ru.catshome.studiojournal.domain.repository.GroupRepository
import javax.inject.Inject
fun Group.mapToEntity():GroupEntity{
    return GroupEntity(
        uid = this.uid, groupName = this.groupName
    )
}
fun GroupEntity.mapToGroup():Group{
    return Group(
        uid = this.uid, groupName = this.groupName
    )
}

class GroupRepositoryImpl @Inject constructor(private val daoGroup: GroupDao): GroupRepository {
    override suspend fun save(group: Group) {
        daoGroup.insertGroup(group = group.mapToEntity())
    }

    override suspend fun loadByUid(): Flow<Group> {
        TODO("Not yet implemented")
    }

    override suspend fun loadAll(): Flow<List<Group>> {
        return daoGroup.loadAllGroup().map {groupEntityList->
        groupEntityList.map {
            Group(
                uid = it.uid, groupName = it.groupName
            )

           }
        }

    }
}