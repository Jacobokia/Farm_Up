package com.cobs.farmup.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cobs.farmup.data.model.Worker

@Database(entities = [Worker::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun workerDao():WorkerDao
}