package com.example.mytranslator.repository

import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.datasource.IDataSourceLocal

class RepositoryImplementationLocal(private val dataSource: IDataSourceLocal<List<SearchResult>>) :
    IRepositoryLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}