package com.example.educonnect.data

import androidx.room.TypeConverter
import com.example.educonnect.model.StudentProfile
import com.example.educonnect.model.TeacherProfile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

inline fun <reified T > Gson.fromJson(json: String) =
    this.fromJson<T>(json, object: TypeToken<T>(){}.type)

open class Converter
{

    @TypeConverter
    fun toDate(date: Long?): Date? {
        return date?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

//    @TypeConverter
//    fun studentProfileToPreference(studentProfile: StudentProfile): String {
//        return Gson().toJson(studentProfile)
//    }
//
//    @TypeConverter
//    fun preferenceToStudentProfile(jasonString: String): StudentProfile
//    {
//        return Gson().fromJson(jasonString)
//    }
//
//    @TypeConverter
//    fun teacherProfileToPreference(teacherProfile: TeacherProfile): String {
//        return Gson().toJson(teacherProfile)
//    }
//
//    @TypeConverter
//    fun preferenceToTeacherProfile(jasonString: String): TeacherProfile
//    {
//        return Gson().fromJson(jasonString)
//    }

}
