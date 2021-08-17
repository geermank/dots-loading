package com.geermank.dots.dot

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import com.geermank.dots.R
import com.geermank.dots.extensions.getColor
import com.geermank.dots.utils.ViewSize

internal class Dot @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var specs: DotSpecs = DotSpecs()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).also { setDotPaintColor(it) }

    constructor(context: Context, dotSpecs: DotSpecs) : this(context) {
        specs = dotSpecs
        setDotPaintColor(paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(specs.getWidth(), specs.getHeight())
    }

    fun getDiameter() = specs.dotSize.getSmallest()

    fun setDiameter(diameter: Int) {
        specs.dotSize = ViewSize(diameter, diameter)
        invalidate()
    }

    fun setColor(@ColorRes color: Int) {
        specs.dotColor = color
        setDotPaintColor(paint)
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        val cx = (width / 2).toFloat()
        val cy = (height / 2).toFloat()
        canvas?.drawCircle(cx, cy, (specs.getHeight() / 2).toFloat(), paint)
    }

    private fun setDotPaintColor(paint: Paint) {
        paint.color = if (specs.colorCanBeDrawn()) {
            getColor(specs.dotColor)
        } else {
            R.attr.colorPrimary
        }
    }
}
