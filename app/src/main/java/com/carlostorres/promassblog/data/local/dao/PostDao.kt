package com.carlostorres.promassblog.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.utils.constants.Constants.POST_TABLE
import kotlinx.coroutines.flow.Flow
@Dao
interface PostDao {

    @Query("SELECT * from $POST_TABLE ORDER BY timeStamp DESC")
    fun getAllPost(): Flow<MutableList<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(post: PostEntity)
}