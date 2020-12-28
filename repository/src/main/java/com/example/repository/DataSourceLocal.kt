package com.example.repository

import com.example.model.DataModel

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(dataModel: DataModel)
}