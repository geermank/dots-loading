package com.geermank.dots.dot

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import com.geermank.dots.R
import com.geermank.dots.extensions.getColor
import com.geermank.dots.extensions.getDimenPixelSize
import com.geermank.dots.utils.ViewSize

internal class Dot @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var specs: DotSpecs = DotSpecs(ViewSize(0, 0))

    constructor(context: Context, size: ViewSize) : this(context) {
        specs = DotSpecs(size)
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = R.attr.colorSecondary
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(specs.getWidth(), specs.getHeight())
    }

    fun setDiameter(diameter: Int) {
        specs.dotSize = ViewSize(diameter, diameter)
        invalidate()
    }

    fun getDiameter() = specs.dotSize.getSmallest()

    fun setColor(@ColorRes color: Int) {
        paint.color = getColor(color)
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        val cx = (width / 2).toFloat()
        val cy = (height / 2).toFloat()
        canvas?.drawCircle(cx, cy, (specs.getHeight() / 2).toFloat(), paint)
    }
}
