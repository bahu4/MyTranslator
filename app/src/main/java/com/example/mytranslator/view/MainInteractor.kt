package com.example.mytranslator.view

import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.viewmodel.IInteractor
import com.example.mytranslator.repository.IRepository
import com.example.mytranslator.repository.IRepositoryLocal


class MainInteractor(
    private val remoteRepository: IRepository<List<SearchResult>>,
    private val repositoryLocal: IRepositoryLocal<List<SearchResult>>
) : IInteractor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(remoteRepository.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
