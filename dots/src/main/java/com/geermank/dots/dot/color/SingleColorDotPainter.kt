package com.geermank.dots.dot.color

import androidx.annotation.ColorRes
import com.geermank.dots.utils.Constants.NO_COLOR

internal class SingleColorDotPainter(@ColorRes private val colorId: Int?) : DotPainter {

    @ColorRes
    override fun getColorForDot(dotIndex: Int): Int {
        return colorId ?: NO_COLOR
    }
}
