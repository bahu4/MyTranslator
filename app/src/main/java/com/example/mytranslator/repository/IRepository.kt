package com.example.mytranslator.repository

import io.reactivex.Observable

interface IRepository<T> {
    fun getData(word: String): Observable<T>
}