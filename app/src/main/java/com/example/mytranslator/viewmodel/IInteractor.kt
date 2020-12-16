package com.example.mytranslator.viewmodel

import io.reactivex.Observable

interface IInteractor<T> {
    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}