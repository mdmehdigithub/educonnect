package com.example.educonnect.data.local.profile

import androidx.room.Dao
import androidx.room.Upsert
import com.example.educonnect.model.StudentProfile
import com.example.educonnect.model.TeacherProfile

@Dao
interface ProfileDAO {
    @Upsert
    suspend fun upsertStudentProfile(studentProfile: StudentProfile)

    @Upsert
    suspend fun upsertTeacherProfile(teacherProfile: TeacherProfile)

}