package com.example.mytranslator.view.main

import geekbrains.ru.core.viewmodel.Interactor
import geekbrains.ru.model.data.DataModel
import geekbrains.ru.model.data.SearchResult
import geekbrains.ru.repository.Repository
import geekbrains.ru.repository.RepositoryLocal

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
