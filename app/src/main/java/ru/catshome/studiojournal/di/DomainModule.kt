package ru.catshome.studiojournal.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.catshome.studiojournal.domain.repository.ChildRepository
import ru.catshome.studiojournal.domain.repository.GroupRepository
import ru.catshome.studiojournal.domain.usecase.LoadChildUseCase
import ru.catshome.studiojournal.domain.usecase.LoadGroupUseCase
import ru.catshome.studiojournal.domain.usecase.SaveChildUseCase
import ru.catshome.studiojournal.domain.usecase.SaveGroupUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideLoadChildUseCase(childRepository: ChildRepository)= LoadChildUseCase( childRepository)
    @Provides
    fun provideSaveChildUseCase(childRepository: ChildRepository)= SaveChildUseCase(childRepository)

    @Provides
    fun provideSaveGroupUseCase(groupRepository: GroupRepository): SaveGroupUseCase{
        return SaveGroupUseCase( groupRepository)
    }
    @Provides
    fun provideLoadGroupUseCase(groupRepository: GroupRepository): LoadGroupUseCase {
        return LoadGroupUseCase( groupRepository)
    }
}