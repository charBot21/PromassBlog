package com.carlostorres.promassblog.utils.viewUtils

import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.DateFormat


fun TextView.setTimeStamp(timestamp: Long) {
    text = DateFormat.getInstance().format(timestamp)
}

fun Fragment.toast(message: Int) {
    Toast.makeText(requireContext(), getString(message), Toast.LENGTH_SHORT).show()
}