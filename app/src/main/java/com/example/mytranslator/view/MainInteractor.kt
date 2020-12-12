package com.example.mytranslator.view

import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.viewmodel.IInteractor
import com.example.mytranslator.repository.IRepository


class MainInteractor (
    private val remoteRepository: IRepository<List<SearchResult>>
) : IInteractor<AppState> {

    override suspend fun getData(word: String): AppState {
        return AppState.Success(remoteRepository.getData(word))
    }
}