package com.example.mytranslator.di

import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.repository.IRepository
import com.example.mytranslator.view.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class InteractorModule {
    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: IRepository<List<SearchResult>>
    ) = MainInteractor(repositoryRemote)
}