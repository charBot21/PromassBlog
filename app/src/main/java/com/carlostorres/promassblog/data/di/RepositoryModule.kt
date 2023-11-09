package com.carlostorres.promassblog.data.di

import com.carlostorres.promassblog.data.remote.FirebaseRepository
import com.carlostorres.promassblog.data.remote.FirebaseRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFirebaseRepository(database: FirebaseFirestore): FirebaseRepository {
        return FirebaseRepositoryImpl(database)
    }
}