package com.example.mytranslator

import com.example.mytranslator.data.AppState

interface IPresenter<T : AppState, V : IMainView> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}