package com.octo.archiexampleengie.android.common.binding

import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class BindingAdaptersImpl : BindingAdapters {
    override fun View.setVisible(show: Boolean) {
        visibility = if (show) View.VISIBLE else View.INVISIBLE
    }

    override fun backgroundColor(view: View, @ColorRes color: Int) {
        view.setBackgroundColor(ContextCompat.getColor(view.context, color))
    }

    override fun backgroundTint(view: View, @ColorRes color: Int) {
        view.backgroundTintList = ContextCompat.getColorStateList(view.context, color)
    }

    override fun tint(view: ImageView, @ColorRes color: Int) {
        view.setColorFilter(ContextCompat.getColor(view.context, color))
    }

    override fun textColor(textView: TextView, @ColorRes color: Int) {
        textView.setTextColor(ContextCompat.getColor(textView.context, color))
    }
}
