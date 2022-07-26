package com.to_panelka.zine.database.repository

import androidx.lifecycle.LiveData
import com.to_panelka.zine.database.dao.ScheduleDao
import com.to_panelka.zine.database.entities.Day
import com.to_panelka.zine.database.entities.ScheduleAndSubjectEntity
import com.to_panelka.zine.database.entities.ScheduleEntity
import com.to_panelka.zine.database.entities.SubjectEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ScheduleRepository(private val scheduleDao: ScheduleDao) {
    private val coroutineScope : CoroutineScope = CoroutineScope(Dispatchers.Main)

    val allSubjects: LiveData<List<SubjectEntity>> = scheduleDao.getAllSubjects()
    val allSchedule: LiveData<List<ScheduleAndSubjectEntity>> = scheduleDao.getAllSchedule()

    fun insertSubject(subject: SubjectEntity){
        coroutineScope.launch(Dispatchers.IO) {
            scheduleDao.insertSubject(subject = subject)
        }
    }

    fun insertSchedule(schedule: ScheduleEntity){
        coroutineScope.launch(Dispatchers.IO){
            scheduleDao.insertSchedule(schedule = schedule)
        }
    }

    fun updateSchedule(schedule: ScheduleEntity){
        coroutineScope.launch(Dispatchers.IO){
            scheduleDao.updateSchedule(schedule = schedule)
        }
    }

}