package com.example.farmacianicols.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FarmaciasDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllFarmacias(mList: List<FarmaciasUsadas>)

    @Query("SELECT * FROM farmacias_table")
    fun showAllFafarmacias(): LiveData<List<FarmaciasUsadas>>

    @Query("SELECT *FROM farmacias_table WHERE id =:mId")
    fun showOnFarmaciasByID(mId : Int): LiveData<FarmaciasUsadas>

    @Update
    suspend fun updateFarmacias(farmaciasUsadas: FarmaciasUsadas)
}