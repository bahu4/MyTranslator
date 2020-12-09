package com.example.mytranslator.presenter

import io.reactivex.Observable

interface IInteractor<T> {
    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}