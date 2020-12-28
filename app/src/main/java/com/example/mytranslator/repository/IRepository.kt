package com.example.mytranslator.repository

interface IRepository<T> {
    suspend fun getData(word: String): T
}