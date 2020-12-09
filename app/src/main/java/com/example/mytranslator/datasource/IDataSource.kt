package com.example.mytranslator.datasource

import io.reactivex.Observable

interface IDataSource<T> {
    fun getData(word: String): Observable<T>
}