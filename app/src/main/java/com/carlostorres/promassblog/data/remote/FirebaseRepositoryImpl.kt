package com.carlostorres.promassblog.data.remote

import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.utils.constants.Constants.POST_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FirebaseRepositoryImpl(
    private val database: FirebaseFirestore,
): FirebaseRepository {
    override suspend fun getPostListToFirestore(): Flow<MutableList<PostEntity>> = flow {
        val getPosts = database.collection(POST_COLLECTION)
        val list = mutableListOf<PostEntity>()

        try {
            getPosts.get()
                .addOnSuccessListener { documents ->
                    for ( document in documents ) {
                        list.add(document.toObject(PostEntity::class.java))
                    }
                }.addOnFailureListener {
                }

            emit(list)
        } catch (exception: Exception) {
            emit(list)
        }
    }

    override suspend fun savePostToFirestore(postEntity: PostEntity): Flow<Boolean> = flow {
        emit(false)
    }
}