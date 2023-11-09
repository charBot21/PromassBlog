package com.carlostorres.promassblog.data.di

import android.content.Context
import androidx.room.Room
import com.carlostorres.promassblog.data.local.db.PostDataBase
import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.utils.constants.Constants.POST_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun providePostDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, PostDataBase::class.java, POST_DATABASE
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providePostDao(postDataBase: PostDataBase) = postDataBase.postDao()

    @Provides
    @Singleton
    fun provideEntity() = PostEntity()
}