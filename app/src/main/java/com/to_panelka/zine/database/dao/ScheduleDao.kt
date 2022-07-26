package com.to_panelka.zine.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.to_panelka.zine.database.entities.ScheduleAndSubjectEntity
import com.to_panelka.zine.database.entities.ScheduleEntity
import com.to_panelka.zine.database.entities.SubjectEntity
import java.sql.Time

@Dao
interface ScheduleDao {

    @Insert
    fun insertSubject(subject:SubjectEntity)

    @Query("SELECT * FROM subjects WHERE title = :title")
    fun getSubject(title:String): LiveData<SubjectEntity>

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): LiveData<List<SubjectEntity>>

    @Query("DELETE FROM subjects WHERE title = :title")
    fun deleteSubject(title: String)

    @Insert
    fun insertSchedule(schedule: ScheduleEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateSchedule(schedule: ScheduleEntity)

    @Transaction
    @Query("SELECT * FROM schedule WHERE day = :day and isOdd = :isOdd")
    fun getSchedule(day:String, isOdd:Boolean):LiveData<List<ScheduleAndSubjectEntity>>

    @Transaction
    @Query("SELECT * FROM schedule")
    fun getAllSchedule():LiveData<List<ScheduleAndSubjectEntity>>


    @Query("DELETE FROM schedule WHERE id=:id")
    fun deleteSchedule(id:Int)

}