package com.carlostorres.promassblog.data.remote

import com.carlostorres.promassblog.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {

    suspend fun getPostListToFirestore(): Flow<MutableList<PostEntity>>

    suspend fun savePostToFirestore(postEntity: PostEntity): Flow<Boolean>
}