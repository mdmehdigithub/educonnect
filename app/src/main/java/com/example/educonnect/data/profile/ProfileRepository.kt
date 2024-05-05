package com.example.educonnect.data.profile


import com.example.educonnect.model.StudentProfile
import com.example.educonnect.model.TeacherProfile

interface ProfileRepository {
    suspend fun upsertStudentProfile(studentProfile: StudentProfile)

    suspend fun upsertTeacherProfile(teacherProfile: TeacherProfile)
}