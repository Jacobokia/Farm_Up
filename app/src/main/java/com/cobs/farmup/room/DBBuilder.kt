package com.cobs.farmup.room

import android.content.Context
import androidx.room.Room

class DBBuilder {
    fun initializeDB(context: Context):AppDatabase{
        val builder = Room.databaseBuilder(context,
            AppDatabase::class.java,
            "farmDB").fallbackToDestructiveMigration()
        return builder.build()

    }
}