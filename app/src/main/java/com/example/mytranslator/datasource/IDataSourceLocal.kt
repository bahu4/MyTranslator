package com.example.mytranslator.datasource

import com.example.mytranslator.data.AppState

interface IDataSourceLocal<T> : IDataSource<T> {
    suspend fun saveToDB(appState: AppState)
}