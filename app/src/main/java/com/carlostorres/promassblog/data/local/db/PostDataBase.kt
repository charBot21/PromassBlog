package com.carlostorres.promassblog.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carlostorres.promassblog.data.local.dao.PostDao
import com.carlostorres.promassblog.data.local.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostDataBase: RoomDatabase() {
    abstract fun postDao(): PostDao
}