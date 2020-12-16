package com.example.mytranslator.view

import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.di.NAME_REMOTE
import com.example.mytranslator.viewmodel.IInteractor
import com.example.mytranslator.repository.IRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val remoteRepository: IRepository<List<SearchResult>>
) : IInteractor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return remoteRepository.getData(word).map { AppState.Success(it) }
    }
}