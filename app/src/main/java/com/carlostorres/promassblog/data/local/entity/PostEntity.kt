package com.carlostorres.promassblog.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.carlostorres.promassblog.utils.constants.Constants.POST_TABLE
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = POST_TABLE)
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "",
    val author: String = "",
    val overview: String = "",
    val timeStamp: Long = System.currentTimeMillis()
): Parcelable