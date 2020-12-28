package com.example.mytranslator.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(HistoryEntity::class), version = 1, exportSchema = false)
abstract class HistoryDB: RoomDatabase() {
    abstract fun historyDAO(): HistoryDAO
}