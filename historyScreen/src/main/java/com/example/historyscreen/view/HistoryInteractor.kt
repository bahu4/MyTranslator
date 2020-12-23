package com.example.historyscreen.view

import com.example.core.viewmodel.Interactor
import com.example.model.DataModel
import com.example.model.SearchResult
import com.example.repository.Repository
import com.example.repository.RepositoryLocal


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