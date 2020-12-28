package com.example.mytranslator.di

import androidx.room.Room
import com.example.historyscreen.view.HistoryInteractor
import com.example.historyscreen.view.HistoryViewModel
import com.example.model.SearchResult
import com.example.mytranslator.view.main.MainInteractor
import com.example.mytranslator.view.main.MainViewModel
import com.example.repository.*
import com.example.repository.room.HistoryDataBase

import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResult>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResult>>> {
        RepositoryImplementationLocal(
            RoomDataBaseImplementation(get())
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
