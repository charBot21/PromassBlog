package com.carlostorres.promassblog.utils.viewUtils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.carlostorres.promassblog.R
import java.text.DateFormat


fun TextView.setTimeStamp(timestamp: Long) {
    text = DateFormat.getInstance().format(timestamp)
}

fun Fragment.toast(message: Int) {
    Toast.makeText(requireContext(), getString(message), Toast.LENGTH_SHORT).show()
}

fun showDialog(title: String, message: String, context: Context) {
    val dialog = Dialog(context)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.error_dialog)
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    val titleDialog = dialog.findViewById<TextView>(R.id.dialogTitle)
    val messageDialog = dialog.findViewById<TextView>(R.id.dialogMessage)

    titleDialog.text = title
    messageDialog.text = message
    dialog.show()
}