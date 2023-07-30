package ru.catshome.studiojournal.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.catshome.data.repository.ChildRepositoryImpl
import ru.catshome.data.repository.GroupRepositoryImpl
import ru.catshome.data.repository.storage.room.AppDatabase
import ru.catshome.data.repository.storage.room.DAO.ChildDao
import ru.catshome.data.repository.storage.room.DAO.GroupDao
import ru.catshome.studiojournal.domain.repository.ChildRepository
import ru.catshome.studiojournal.domain.repository.GroupRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context)=   Room.databaseBuilder(context,
        AppDatabase::class.java, "StudioJournalDb").build()

    @Provides
    @Singleton
    fun provideGroupDao(database: AppDatabase):GroupDao{
        return database.groupDao()
    }

    @Provides
    @Singleton
    fun provideChildDao(database: AppDatabase):ChildDao{
        return database.childDao()
    }

    @Provides
    @Singleton
    fun provideGroupRepository(groupDao: GroupDao):GroupRepository{
        return GroupRepositoryImpl(groupDao)
    }
    @Provides
    @Singleton
    fun provideChildRepository(childDao: ChildDao):ChildRepository{
        return ChildRepositoryImpl(childDao)
    }

}