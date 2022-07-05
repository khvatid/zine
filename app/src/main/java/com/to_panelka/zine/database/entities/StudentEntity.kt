package com.to_panelka.zine.database.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "students")
class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int = 0
    @ColumnInfo(name = "name")
    var name: String = ""

    constructor(){}

    constructor(name: String){
        this.name=name
    }
}