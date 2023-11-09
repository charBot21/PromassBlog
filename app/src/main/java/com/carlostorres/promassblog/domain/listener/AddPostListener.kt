package com.carlostorres.promassblog.domain.listener

interface AddPostListener {
    fun onEmptyFields()
    fun success()
}