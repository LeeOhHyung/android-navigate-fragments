/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.utility

import androidx.fragment.app.Fragment
import kr.ohyung.common.shared.Action
import kr.ohyung.navigation.ParentActivity

internal val Fragment.sharedViewModel get() =
    (requireActivity() as ParentActivity).sharedViewModel

internal val Fragment.parentActivity get() =
    (requireActivity() as ParentActivity)

fun Fragment.navigate(action: Action) =
    (requireActivity() as ParentActivity).navigate(action)
