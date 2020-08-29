package kr.ohyung.navigation.utility.extension

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.load(imageUrl: String, @DrawableRes placeHolder: Int = 0) {
    Glide.with(this).load(imageUrl).placeholder(placeHolder).into(this)
}

fun ImageView.load(@DrawableRes resId: Int, @DrawableRes placeHolder: Int = 0) {
    Glide.with(this).load(resId).placeholder(placeHolder).into(this)
}

fun ImageView.load(context: Context, imageUrl: String, @DrawableRes placeHolder: Int = 0) {
    Glide.with(context).load(imageUrl).placeholder(placeHolder).into(this)
}

fun ImageView.load(context: Context, @DrawableRes resId: Int, placeHolder: Int = 0) {
    Glide.with(context).load(resId).placeholder(placeHolder).into(this)
}
