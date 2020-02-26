package com.luigi573.rippleview

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.RadialGradient
import android.graphics.Shader

class RadialRippleDrawable : RippleDrawable() {

    override val mAnimator = animatorOf {
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addUpdateListener {
            trans = it.animatedValue as Float
        }
        duration = 900
    }

    override var trans: Float = 0F
        set(value) {
            field = value
            val scale: Float = 24 * value
            mMatrix.apply {
                setScale(scale, scale, centerX, centerY)
            }
            invalidateSelf()
        }

    override fun draw(canvas: Canvas) {
        val gradient = RadialGradient(
            centerX, centerY, minOf(centerX, centerY),
            mColors, mPositions,
            Shader.TileMode.CLAMP
        )
        gradient.setLocalMatrix(mMatrix)
        mPaint.shader = gradient
        canvas.drawRect(
            0F, 0F, width.toFloat(), height.toFloat(), mPaint
        )
    }

}