package com.carlostorres.promassblog.utils.viewUtils

import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText
import java.text.DateFormat

@BindingAdapter("setTimestamp")
fun setTimestamp(date: TextView, timestamp: Long) {
    date.text = DateFormat.getInstance().format(timestamp)
}

@BindingAdapter("onTextChanged")
fun TextInputEditText.onTextChanged(onTextChanged: OnTextChange) {
    addTextChangedListener {
        onTextChanged.onChanged()
    }
}

interface OnTextChange {
    fun onChanged()
}