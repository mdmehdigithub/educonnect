package com.example.educonnect.di.repository

import com.example.educonnect.data.local.profile.ProfileDAO
import com.example.educonnect.data.local.profile.ProfileOfflineRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ProfileRepository {
    @Singleton
    @Provides
    fun providesProfileRepository(profileDAO: ProfileDAO): ProfileOfflineRepository {
        return ProfileOfflineRepository(profileDAO)
    }
}