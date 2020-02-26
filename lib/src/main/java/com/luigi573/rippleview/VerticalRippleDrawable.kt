package com.luigi573.rippleview

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Shader

class VerticalRippleDrawable : RippleDrawable() {

    override val mAnimator = animatorOf {
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addUpdateListener {
            trans = it.animatedValue as Float
        }
        duration = 900
    }
    override var trans : Float = 0F
        set(value) {
            field = value
            val dy : Float = value * height * 2
            mMatrix.apply {
                setTranslate(0f, -dy)
            }
            invalidateSelf()
        }

    override fun draw(canvas: Canvas) {
        val gradient = LinearGradient(
            0F, height.toFloat(),
            0F, height.toFloat() * 2,
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