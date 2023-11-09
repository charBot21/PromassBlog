package com.carlostorres.promassblog.data.remote

import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.utils.constants.Constants.POST_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.task.await

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
        try {
            val newPost = database.collection(POST_COLLECTION).document("${postEntity.id}")
            var uploadSuccessful: Boolean = false
            newPost.set(postEntity, SetOptions.merge())
                .addOnSuccessListener {
                    uploadSuccessful = true
                }.addOnFailureListener {
                    uploadSuccessful = false
                }//.await()
            emit(uploadSuccessful)
        } catch (exception: Exception) {
            emit(false)
        }
    }
}