package com.example.mytranslator.view

import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.presenter.IInteractor
import com.example.mytranslator.repository.IRepository
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: IRepository<List<SearchResult>>
) : IInteractor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return remoteRepository.getData(word).map { AppState.Success(it) }
    }
}