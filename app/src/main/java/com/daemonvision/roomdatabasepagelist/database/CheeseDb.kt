package com.daemonvision.roomdatabasepagelist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Singleton database object. Note that for a real app, you should probably use a Dependency
 * Injection framework or Service Locator to create the singleton database.
 */
@Database(entities = [Cheese::class], version = 1, exportSchema = false)
abstract class CheeseDb: RoomDatabase() {

    abstract fun cheeseDao(): CheeseDao

    companion object{
        @Volatile
        private var INSTANCE: CheeseDb ?= null

        fun getInstance(context: Context): CheeseDb
        {
            synchronized(this)
            {
                var instance = INSTANCE
                if (instance == null)
                {
                    instance = Room.databaseBuilder(context.applicationContext,CheeseDb::class.java,
                        "CheeseDatabase")
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}