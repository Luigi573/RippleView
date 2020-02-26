package com.luigi573.rippleview

import android.animation.ValueAnimator
import android.graphics.*
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable

abstract class RippleDrawable : Drawable(), Animatable {

    abstract val mAnimator: ValueAnimator

    protected abstract var trans: Float

    protected val mPaint = Paint().apply {
        isAntiAlias = true
    }

    protected val mMatrix = Matrix()

    protected var mColors = intArrayOf(
        Color.parseColor("#D5D9D5"),
        Color.parseColor("#EEEEEE"),
        Color.parseColor("#D5D9D5")
    )

    protected val mPositions = floatArrayOf(0F, 0.5F, 1.0F)

    var rippleBgColor = Color.parseColor("#D5D9D5")
        set(value) {
            field = value
            mColors[0] = value
            mColors[2] = value
        }

    var rippleColor = Color.parseColor("#EEEEEE")
        set(value) {
            field = value
            mColors[1] = value
        }

    var duration: Long = 1000
        set(value) {
            mAnimator.duration = value
            field = value
        }


    abstract override fun draw(canvas: Canvas)

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun getOpacity(): Int = mPaint.alpha

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    override fun isRunning() = mAnimator.isRunning

    override fun start() = mAnimator.start()

    override fun stop() = mAnimator.cancel()


}