package com.example.farmacianicols.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FarmaciasUsadas::class],version = 1)

abstract class FarmaciasDatBaseee : RoomDatabase() {

    abstract fun farmaciasDao(): FarmaciasDao

    companion object {
        @Volatile
        private var INSTANCE : FarmaciasDatBaseee? = null

        fun getDataBase(context: Context): FarmaciasDatBaseee {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                        FarmaciasDatBaseee::class.java,"farmaciasDb")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}