package com.to_panelka.zine.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.to_panelka.zine.database.repository.StudentsRepository
import com.to_panelka.zine.database.ZineDatabase
import com.to_panelka.zine.database.entities.StudentEntity

class StudentsViewModel(application: Application): ViewModel() {
    val allStudents: LiveData<List<StudentEntity>>
    private val repository: StudentsRepository
    val searchResults: MutableLiveData<List<StudentEntity>>
    init {
        val zineDatabase = ZineDatabase.getInstance(application)
        val studentDao = zineDatabase.studentDao()
        repository = StudentsRepository(studentDao)

        allStudents = repository.allStudents
        searchResults = repository.searchResults
    }

    fun insertStudent(student:StudentEntity){
        repository.insertStudent(student)
    }

    fun findStudent(name: String){
        repository.findStudent(name)
    }

    fun deleteStudent(name: String){
        repository.deleteStudent(name)
    }


}