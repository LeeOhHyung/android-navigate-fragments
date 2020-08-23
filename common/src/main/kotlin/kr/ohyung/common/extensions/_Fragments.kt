package kr.ohyung.common.extensions

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.toast(@StringRes message: Int) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

fun Fragment.toast(message: String) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
