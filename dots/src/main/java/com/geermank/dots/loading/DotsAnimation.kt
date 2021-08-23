package com.geermank.dots.loading

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.view.DotLoadingView

internal interface DotsAnimation {
    fun animateDot(container: DotLoadingView, dot: Dot, dotIndex: Int)
}