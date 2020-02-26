package com.luigi573.rippleview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.widget.ImageView
import java.lang.IllegalArgumentException

class RippleView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr), Animatable {

    companion object {
        const val STYLE_VERTICAL = 0x01

        const val STYLE_RADIAL = 0x02
    }

    var style: Int = 0x01
        set(value) {
            field = value
            drawable = when (value) {
                0x01 -> VerticalRippleDrawable()
                0x02 -> RadialRippleDrawable()
                else -> throw IllegalArgumentException("A style value must be STYLE_VERTICAL or STYLE_RADIAL")
            }
            setImageDrawable(drawable)
            start()
        }

    private var drawable: RippleDrawable = VerticalRippleDrawable()

    var duration: Long = drawable.duration
        set(value) {
            field = value
            drawable.duration = value
        }

    var rippleColor: Int = drawable.rippleColor
        set(value) {
            field = value
            drawable.rippleColor = value
        }

    var rippleBgColor: Int = drawable.rippleBgColor
        set(value) {
            field = value
            drawable.rippleBgColor = value
        }


    init {
        attrs?.let {
            inflateAttrs(it)
        }
        setImageDrawable(drawable)
        start()
    }

    private fun inflateAttrs(attrs: AttributeSet) {
        val resAttrs = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RippleView,
            0,
            0
        )

        with(resAttrs) {
            style = getInt(R.styleable.RippleView_ripple_style, style)
            duration = getInteger(
                R.styleable.RippleView_animate_duration,
                duration.toInt()
            ).toLong()
            rippleColor = getColor(
                R.styleable.RippleView_ripple_color,
                Color.parseColor("#EEEEEE")
            )
            rippleBgColor = getColor(
                R.styleable.RippleView_ripple_backgroundColor,
                Color.parseColor("#D5D9D5")
            )
        }
    }

    override fun isRunning() = drawable.isRunning

    override fun start() = drawable.start()

    override fun stop() = drawable.stop()

}