/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.utility

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

inline fun <T: ViewBinding> AppCompatActivity.viewBinding(
    crossinline inflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) { inflater.invoke(layoutInflater) }
