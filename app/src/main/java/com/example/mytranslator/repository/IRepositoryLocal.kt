package com.example.mytranslator.repository

import com.example.mytranslator.data.AppState

interface IRepositoryLocal<T> : IRepository<T> {
    suspend fun saveToDB(appState: AppState)
}