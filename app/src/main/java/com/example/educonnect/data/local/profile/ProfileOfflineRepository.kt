package com.example.educonnect.data.local.profile

import com.example.educonnect.model.StudentProfile
import com.example.educonnect.model.TeacherProfile

class ProfileOfflineRepository(
    private val profileDAO: ProfileDAO
) : ProfileRepository {
    override suspend fun upsertStudentProfile(studentProfile: StudentProfile) = profileDAO.upsertStudentProfile(studentProfile)

    override suspend fun upsertTeacherProfile(teacherProfile: TeacherProfile) = profileDAO.upsertTeacherProfile(teacherProfile)
}