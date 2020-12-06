package com.example.mytranslator.repository

import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.datasource.IDataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: IDataSource<List<SearchResult>>) :
    IRepository<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        return dataSource.getData(word)
    }
}