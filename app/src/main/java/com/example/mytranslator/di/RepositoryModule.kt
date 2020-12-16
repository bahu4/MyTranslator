package com.example.mytranslator.di

import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.datasource.IDataSource
import com.example.mytranslator.datasource.RetrofitImplementation
import com.example.mytranslator.repository.IRepository
import com.example.mytranslator.repository.RepositoryImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun providesRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: IDataSource<List<SearchResult>>): IRepository<List<SearchResult>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): IDataSource<List<SearchResult>> =
        RetrofitImplementation()
}