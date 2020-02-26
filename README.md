# RippleView ![](https://jitpack.io/v/Luigi573/RippleView.svg)

波纹状加载动画View

## Usage

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

**DO NOT add to buildscript's dependencies** 

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
    implementation 'com.github.Luigi573:RippleView:1.0.0'
}
```

```kotlin
//动画周期 app:animate_duration
mRippleView.duration = 1200L
//波纹样式 垂直移动/中心扩散 app:ripple_style
mRippleView.style = RippleView.STYLE_VERTICAL
mRippleView.style = RippleView.STYLE_RADIAL
//底色 app:ripple_backgroundColor
mRippleView.rippleBgColor = Color.parseColor("#D5D9D5")
//主要颜色 app:ripple_color
mRippleView.rippleColor = Color.parseColor("#EEEEEE")
```

