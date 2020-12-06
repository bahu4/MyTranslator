package com.example.mytranslator

import com.example.mytranslator.data.AppState

interface IMainView {
    fun renderData(appState: AppState)
}