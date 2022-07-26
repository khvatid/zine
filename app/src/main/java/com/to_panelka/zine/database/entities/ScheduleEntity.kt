package com.to_panelka.zine.database.entities

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.sql.Time

enum class Type(val value:Int){
    Lecture(value = 1),
    Practice(value = 2),
    Laboratory(value = 3)
}
enum class Day{
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

@Entity(tableName = "subjects")
data class SubjectEntity (
    @PrimaryKey
    val title : String
)

@Entity(tableName = "schedule",
foreignKeys = [ForeignKey(
    entity = SubjectEntity::class,
    parentColumns = arrayOf("title"),
    childColumns = arrayOf("title"),
    onUpdate = ForeignKey.CASCADE,
    onDelete = ForeignKey.CASCADE
)])
data class ScheduleEntity(
@PrimaryKey(autoGenerate = true)
val id : Int,

val title: String,
val day: String = Day.Monday.name,
val isOdd: Boolean = false,
val type: Int = Type.Lecture.value
)

data class ScheduleAndSubjectEntity(
    @Embedded val subject : SubjectEntity,
    @Relation(
        parentColumn = "title",
        entityColumn = "title"
    ) val schedule : List<ScheduleEntity>,
)


