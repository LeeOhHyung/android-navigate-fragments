/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.utility

import androidx.fragment.app.Fragment
import kr.ohyung.navigation.NavigationAction
import kr.ohyung.navigation.ParentActivity

internal val Fragment.sharedViewModel get() =
    (requireActivity() as ParentActivity).sharedViewModel

internal val Fragment.parentActivity get() =
    (requireActivity() as ParentActivity)

internal fun Fragment.navigate(action: NavigationAction) =
    (requireActivity() as ParentActivity).navigate(action)
