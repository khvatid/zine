package com.to_panelka.zine.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.to_panelka.zine.database.dao.ProfileDao
import com.to_panelka.zine.database.dao.StudentDao
import com.to_panelka.zine.database.entities.ProfileEntity
import com.to_panelka.zine.database.entities.StudentEntity


@Database(entities = [(StudentEntity::class),(ProfileEntity::class)], version = 2)
abstract class ZineDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun profileDao(): ProfileDao

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