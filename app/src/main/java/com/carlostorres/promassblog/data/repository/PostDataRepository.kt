package com.carlostorres.promassblog.data.repository

import com.carlostorres.promassblog.data.local.dao.PostDao
import com.carlostorres.promassblog.data.local.entity.PostEntity
import javax.inject.Inject

class PostDataRepository @Inject constructor(private val postDao: PostDao) {
    suspend fun insertpost(post: PostEntity) = postDao.insertNote(post)
    fun getAllPost() = postDao.getAllPost()
}