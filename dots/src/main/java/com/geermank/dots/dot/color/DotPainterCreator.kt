package com.geermank.dots.dot.color

internal object DotPainterCreator {

    fun create(primaryDotsColor: Int?, multipleColorsArray: IntArray?): DotPainter {
        return if (multipleColorsArray == null) {
            SingleColorDotPainter(primaryDotsColor)
        } else {
            createDotPainterBasedOnMultipleColorsArray(primaryDotsColor, multipleColorsArray)
        }
    }

    private fun createDotPainterBasedOnMultipleColorsArray(
        primaryDotsColor: Int?,
        multipleColorsArray: IntArray
    ): DotPainter {
        return if (multipleColorsArray.size == 1) {
            SingleColorDotPainter(multipleColorsArray.first())
        } else {
            MultipleColorsDotPainter(primaryDotsColor, multipleColorsArray)
        }
    }
}
