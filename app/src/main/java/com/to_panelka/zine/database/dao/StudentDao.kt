package com.to_panelka.zine.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.to_panelka.zine.database.entities.StudentEntity


@Dao
interface StudentDao {

  @Insert
  fun insertStudent(student: StudentEntity)

  @Query("SELECT * FROM students WHERE name = :name")
  fun findStudent(name: String): List<StudentEntity>

  @Query("DELETE FROM students WHERE name= :name")
  fun deleteStudent(name:String)

  @Query("SELECT * FROM students")
  fun getAllStudent(): LiveData<List<StudentEntity>>
}