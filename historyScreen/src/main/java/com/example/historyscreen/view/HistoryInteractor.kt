package com.example.historyscreen.view

import geekbrains.ru.core.viewmodel.Interactor
import geekbrains.ru.model.data.DataModel
import geekbrains.ru.model.data.SearchResult
import geekbrains.ru.repository.Repository
import geekbrains.ru.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResult>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResult>>
) : Interactor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        return DataModel.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}