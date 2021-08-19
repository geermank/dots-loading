package com.geermank.dots.dot.color

import androidx.annotation.ColorRes

internal interface DotPainter {
    @ColorRes
    fun getColorForDot(dotIndex: Int): Int
}
