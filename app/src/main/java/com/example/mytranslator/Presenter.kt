package com.example.mytranslator

import com.example.mytranslator.data.AppState

interface Presenter<T : AppState, V : MainView> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}