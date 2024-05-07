package com.example.educonnect.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.educonnect.data.Constants.DATABASE_NAME
import com.example.educonnect.data.local.profile.ProfileDAO
import com.example.educonnect.model.Notes
import com.example.educonnect.model.StudentProfile
import com.example.educonnect.model.TeacherProfile

@Database(
    entities = [
        StudentProfile::class,
        TeacherProfile::class,
        Notes::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converter::class)
abstract class EduConnectDatabase: RoomDatabase()
{
    abstract fun profileDAO(): ProfileDAO
    companion object {
        @Volatile
        private var Instance: EduConnectDatabase? = null
        fun getDatabase(context: Context): EduConnectDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context = context, klass =  EduConnectDatabase::class.java, name = DATABASE_NAME)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
