package com.example.mytranslator

import io.reactivex.Observable

interface DataSource<T> {
    fun getData(word: String): Observable<T>
}