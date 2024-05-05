package com.example.educonnect.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_profile")
data class StudentProfile(
    @PrimaryKey
    val studentID: String,
    val name: String,
    val password: String
)

@Entity(tableName = "teacher_profile")
data class TeacherProfile(
    @PrimaryKey
    val teacherID: String,
    val name: String,
    val password: String
)