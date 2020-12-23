package com.example.repository

import com.example.model.DataModel


interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(dataModel: DataModel)
}