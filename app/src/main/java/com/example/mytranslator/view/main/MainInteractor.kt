package com.example.mytranslator.view.main

import com.example.core.viewmodel.Interactor
import com.example.model.DataModel
import com.example.model.SearchResult
import com.example.repository.Repository
import com.example.repository.RepositoryLocal


class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResult>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResult>>
) : Interactor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        val dataModel: DataModel
        if (fromRemoteSource) {
            dataModel = DataModel.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(dataModel)
        } else {
            dataModel = DataModel.Success(repositoryLocal.getData(word))
        }
        return dataModel
    }
}
