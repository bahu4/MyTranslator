package com.example.mytranslator.di

import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.datasource.RetrofitImplementation
import com.example.mytranslator.repository.IRepository
import com.example.mytranslator.repository.RepositoryImplementation
import com.example.mytranslator.view.MainInteractor
import com.example.mytranslator.view.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<IRepository<List<SearchResult>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get()) }
    factory { MainViewModel(get()) }
}