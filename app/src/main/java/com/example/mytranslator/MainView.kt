package com.example.mytranslator

import com.example.mytranslator.data.AppState

interface MainView {
    fun renderData(appState: AppState)
}