package com.example.mytranslator.datasource

import com.example.mytranslator.data.AppState
import com.example.mytranslator.data.SearchResult
import com.example.mytranslator.room.HistoryDAO
import com.example.mytranslator.utils.convertSearchResultSuccessToEntity
import com.example.mytranslator.utils.mapHistoryEntityToSearchResult

class RoomDBImplementation(private val historyDAO: HistoryDAO) :
    IDataSourceLocal<List<SearchResult>> {
    override suspend fun saveToDB(appState: AppState) {
        convertSearchResultSuccessToEntity(appState)?.let {
            historyDAO.insert(it)
        }
    }

    override suspend fun getData(word: String): List<SearchResult> {
        return mapHistoryEntityToSearchResult(historyDAO.all())
    }
}