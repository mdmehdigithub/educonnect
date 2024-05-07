package com.example.educonnect.di.database

import android.content.Context
import androidx.room.Room
import com.example.educonnect.data.Constants.DATABASE_NAME
import com.example.educonnect.data.EduConnectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {
    @Singleton
    @Provides
    fun provideHeavyDutyDb(@ApplicationContext context: Context): EduConnectDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = EduConnectDatabase::class.java,
            name = DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}