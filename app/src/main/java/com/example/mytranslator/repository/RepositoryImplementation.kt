package com.example.mytranslator.repository

import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.datasource.IDataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: IDataSource<List<SearchResult>>) :
    IRepository<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }
}