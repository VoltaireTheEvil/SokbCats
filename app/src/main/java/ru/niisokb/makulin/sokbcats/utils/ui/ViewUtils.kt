package ru.niisokb.makulin.sokbcats.utils.ui

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.makeSnackbar(
    text: String,
    actionText: String? = null,
    action: View.OnClickListener? = null
) {
    if (action != null && actionText != null) {
        Snackbar.make(this, text, Snackbar.LENGTH_LONG).setAction(actionText, action).show()
    } else {
        Snackbar.make(this, text, Snackbar.LENGTH_LONG).show()
    }
}