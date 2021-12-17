package com.example.foodorder

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.core.widget.TextViewCompat

fun Context.colorList(id: Int): ColorStateList {
    return ColorStateList.valueOf(ContextCompat.getColor(this, id))
}

fun ImageView.setTint(color: Int) {
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(ContextCompat.getColor(context, color)))
}
fun TextView.setTextColorRes(@ColorRes colorRes: Int) {
    val color = ContextCompat.getColor(context, colorRes)
    setTextColor(color)
}