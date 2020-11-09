package com.rathiesh.countrydetail.extenstion

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.rathiesh.countrydetail.constants.RETRY

fun Activity.showError(root: View, msg: String) {
    Snackbar.make(root, msg, Snackbar.LENGTH_LONG).show()
}


fun Activity.showError(
    root: View,
    msg: String,
    listener: View.OnClickListener) {
    Snackbar.make(root, msg, Snackbar.LENGTH_INDEFINITE).setAction(RETRY,listener).show()
}