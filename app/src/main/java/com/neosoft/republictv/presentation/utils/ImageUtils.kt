package com.neosoft.republictv.presentation.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

/**
 * Created by Vijay on 30/8/19.
 */

fun ImageView.load(url: String, @DrawableRes placeHolder: Int) {

    Glide.with(this).load(url).placeholder(placeHolder)
        .into(this)

}