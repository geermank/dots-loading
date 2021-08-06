package com.geermank.dots.loading

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.view.DotLoading

interface DotsAnimation {
    fun animateDot(container: DotLoading, dot: Dot, dotIndex: Int)
}