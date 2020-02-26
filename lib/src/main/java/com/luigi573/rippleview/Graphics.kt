package com.luigi573.rippleview

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.View

internal fun Resources.dip(value: Int): Int = (value * displayMetrics.density).toInt()

internal fun Context.dip(value: Int): Int = resources.dip(value)
internal fun View.dip(value: Int): Int = resources.dip(value)

internal fun animatorOf(init : ValueAnimator.() -> Unit) : ValueAnimator{
    return ValueAnimator.ofFloat(0F, 1F).apply(init)
}

internal val Drawable.width: Int get() = bounds.width()
internal val Drawable.height: Int get() = bounds.height()
internal val Drawable.centerX: Float get() = width.toFloat() / 2
internal val Drawable.centerY: Float get() = height.toFloat() / 2
