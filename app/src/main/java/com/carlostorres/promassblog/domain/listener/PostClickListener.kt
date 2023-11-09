package com.carlostorres.promassblog.domain.listener

import com.carlostorres.promassblog.data.local.entity.PostEntity

interface PostClickListener {
    fun onClick(item: PostEntity)
}