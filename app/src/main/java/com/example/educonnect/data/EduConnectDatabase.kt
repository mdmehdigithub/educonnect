package com.example.educonnect.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.educonnect.model.Notes

@Database(
    entities = [Notes::class],
    version = 1,
    exportSchema = false)
abstract class EduConnectDatabase: RoomDatabase()
{
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

private const val DATABASE_NAME = "edu_database"