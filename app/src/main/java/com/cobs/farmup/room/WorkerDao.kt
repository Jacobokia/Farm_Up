package com.cobs.farmup.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cobs.farmup.data.model.Worker

@Dao
interface WorkerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkers(vararg workers: Worker)

    @Update
    fun updateWorkers(vararg workers: Worker)

    @Delete
    fun deleteWorkers(vararg workers:Worker)

    @Query("Select * from Worker")
    fun loadAllWorkers():List<Worker>


}