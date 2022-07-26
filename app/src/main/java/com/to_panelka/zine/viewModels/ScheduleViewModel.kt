package com.to_panelka.zine.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.to_panelka.zine.database.ZineDatabase
import com.to_panelka.zine.database.entities.ScheduleAndSubjectEntity
import com.to_panelka.zine.database.entities.ScheduleEntity
import com.to_panelka.zine.database.entities.SubjectEntity
import com.to_panelka.zine.database.repository.ScheduleRepository

class ScheduleViewModel(application: Application): ViewModel() {
    private val repository : ScheduleRepository

    val allSubject: LiveData<List<SubjectEntity>>
    val allSchedule: LiveData<List<ScheduleAndSubjectEntity>>
    init {
        val zineDatabase = ZineDatabase.getInstance(application)
        val scheduleDao = zineDatabase.scheduleDao()
        repository = ScheduleRepository(scheduleDao)

        allSubject = repository.allSubjects
        allSchedule = repository.allSchedule
    }

    fun insertSubject(subject: SubjectEntity){
        repository.insertSubject(subject)
    }

    fun insertSchedule(schedule: ScheduleEntity){
        repository.insertSchedule(schedule)
    }

    fun updateSchedule(schedule: ScheduleEntity){
        repository.updateSchedule(schedule)
    }


}