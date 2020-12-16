package com.example.mytranslator.viewmodel

interface IInteractor<T> {
    suspend fun getData(word: String): T
}