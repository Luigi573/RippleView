package com.luigi573.rippleviewsample

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.luigi573.rippleview.RippleView

class MainActivity : AppCompatActivity() {
    private lateinit var mRippleView: RippleView
    private lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)

        mRippleView = findViewById(R.id.rippleView)
        mButton = findViewById(R.id.toggle_btn)

        //动画周期
        mRippleView.duration = 1200L
        //波纹样式 垂直移动/中心扩散
        mRippleView.style = RippleView.STYLE_VERTICAL
        mRippleView.style = RippleView.STYLE_RADIAL
        //底色
        mRippleView.rippleBgColor = Color.parseColor("#D5D9D5")
        //主要颜色
        mRippleView.rippleColor = Color.parseColor("#EEEEEE")

        mButton.apply {
            setOnClickListener {
                if (mRippleView.style == RippleView.STYLE_VERTICAL) {
                    mRippleView.style = RippleView.STYLE_RADIAL
                    mButton.text = "RADIAL"
                } else {
                    mRippleView.style = RippleView.STYLE_VERTICAL
                    mButton.text = "VERTICAL"
                }
            }
        }


    }
}