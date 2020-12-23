package com.example.repository

import com.example.model.DataModel
import com.example.model.SearchResult
import com.example.repository.room.HistoryDao


class RoomDataBaseImplementation(private val historyDao: HistoryDao) : DataSourceLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        convertDataModelSuccessToEntity(dataModel)?.let {
            historyDao.insert(it)
        }
    }
}