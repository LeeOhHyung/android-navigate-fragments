/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.utility

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kr.ohyung.navigation.ParentActivity

internal val Fragment.sharedViewModel get() =
    (requireActivity() as ParentActivity).sharedViewModel

internal fun Fragment.toast(@StringRes message: Int) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

internal fun Fragment.toast(message: String) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
