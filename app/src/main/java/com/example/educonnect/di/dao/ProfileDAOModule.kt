package com.example.educonnect.di.dao

import com.example.educonnect.data.EduConnectDatabase
import com.example.educonnect.data.local.profile.ProfileDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ProfileDAOModule {
    @Singleton
    @Provides
    fun providesProfileDAOModule(eduConnectDatabase: EduConnectDatabase): ProfileDAO {
        return eduConnectDatabase.profileDAO()
    }
}