package com.octo.archiexampleengie.android.common.binding

import android.databinding.BindingAdapter
import android.support.annotation.ColorRes
import android.view.View
import android.widget.ImageView
import android.widget.TextView


interface BindingAdapters {
    @BindingAdapter("visible")
    fun View.setVisible(show: Boolean)

    @BindingAdapter("background")
    fun backgroundColor(view: View, @ColorRes color: Int)

    @BindingAdapter("backgroundTint")
    fun backgroundTint(view: View, @ColorRes color: Int)

    @BindingAdapter("tint")
    fun tint(view: ImageView, @ColorRes color: Int)

    @BindingAdapter("textColor")
    fun textColor(textView: TextView, @ColorRes color: Int)
}
