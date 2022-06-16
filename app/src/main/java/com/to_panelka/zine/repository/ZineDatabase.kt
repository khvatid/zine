package com.to_panelka.zine.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.to_panelka.zine.repository.dao.StudentDao
import com.to_panelka.zine.repository.entities.StudentEntity


@Database(entities = [(StudentEntity::class)], version = 1)
abstract class ZineDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        private var INSTANCE: ZineDatabase? = null

        fun getInstance(context: Context): ZineDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ZineDatabase::class.java,
                        "zine_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}