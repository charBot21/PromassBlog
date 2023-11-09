package com.carlostorres.promassblog.utils.viewUtils

import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.domain.listener.PostClickListener
import com.carlostorres.promassblog.ui.adapter.PostAdapter
import com.google.android.material.textfield.TextInputEditText
import java.text.DateFormat


@BindingAdapter(value = ["setNotes", "setListener"], requireAll = true)
fun RecyclerView.setNotes(items: List<PostEntity>?, listener: PostClickListener) {
    items?.let {
        LinearLayoutManager(context)
        adapter = PostAdapter(it, listener)
    }
}
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