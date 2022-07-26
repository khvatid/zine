package com.to_panelka.zine.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.to_panelka.zine.database.dao.ProfileDao
import com.to_panelka.zine.database.dao.ScheduleDao
import com.to_panelka.zine.database.dao.StudentDao
import com.to_panelka.zine.database.entities.ProfileEntity
import com.to_panelka.zine.database.entities.ScheduleEntity
import com.to_panelka.zine.database.entities.StudentEntity
import com.to_panelka.zine.database.entities.SubjectEntity
import com.to_panelka.zine.screens.schedule.ScheduleUi


@Database(entities = [(StudentEntity::class),(ProfileEntity::class),(SubjectEntity::class),(ScheduleEntity::class)], version = 4)
abstract class ZineDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun profileDao(): ProfileDao
    abstract fun scheduleDao(): ScheduleDao

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