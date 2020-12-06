package com.example.mytranslator.datasource

import com.example.mytranslator.data.SearchResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("word/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<SearchResult>>
}