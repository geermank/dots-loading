package com.geermank.dots.dot.color

import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import com.geermank.dots.utils.Constants.NO_COLOR

internal class MultipleColorsDotPainter(
    @ColorRes private val primaryDotColor: Int?, // the user may not have set this value
    @ArrayRes private val colorsIds: IntArray
) : DotPainter {

    @ColorRes
    override fun getColorForDot(dotIndex: Int): Int {
        return if (dotIndex > colorsIds.lastIndex) {
            // if we have more dots than colors, we paint the rest with
            // the primary color (if it has been provided). If not, just specify that we don't
            // have a color to paint with
            primaryDotColor ?: NO_COLOR
        } else {
            colorsIds[dotIndex]
        }
    }
}
