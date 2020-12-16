package com.example.mytranslator.datasource

interface IDataSource<T> {
    suspend fun getData(word: String): T
}