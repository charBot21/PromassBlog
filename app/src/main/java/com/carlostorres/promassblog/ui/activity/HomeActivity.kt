package com.carlostorres.promassblog.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlostorres.promassblog.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}