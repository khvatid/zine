package com.to_panelka.zine.database.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.to_panelka.zine.database.dao.StudentDao
import com.to_panelka.zine.database.entities.StudentEntity
import kotlinx.coroutines.*

class StudentsRepository(private val studentDao: StudentDao) {

    val allStudents: LiveData<List<StudentEntity>> = studentDao.getAllStudent()
    val searchResults = MutableLiveData<List<StudentEntity>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertStudent(newStudent: StudentEntity) {
        coroutineScope.launch(Dispatchers.IO) {
            studentDao.insertStudent(newStudent)
        }
    }

    fun deleteStudent(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            studentDao.deleteStudent(name)
        }
    }

    fun findStudent(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private fun asyncFind(name: String): Deferred<List<StudentEntity>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async studentDao.findStudent(name)
        }
}


