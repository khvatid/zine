package com.to_panelka.zine.database.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "profile")
data class ProfileEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "fullName")
    val fullName: String,

    @ColumnInfo(name = "photo")
    val photo : String?

)