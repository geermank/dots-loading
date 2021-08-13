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

internal class Dot @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val specs = DotSpecs(getDimenPixelSize(R.dimen.large_dot_diameter))
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = R.attr.colorSecondary
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(
            getDimenPixelSize(R.dimen.large_dot_diameter),
            getDimenPixelSize(R.dimen.large_dot_diameter)
        )
    }

    fun setDiameter(diameter: Int) {
        specs.diameter = diameter
        invalidate()
    }

    fun getDiameter() = specs.diameter

    fun setColor(@ColorRes color: Int) {
        paint.color = getColor(color)
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        val cx = (width / 2).toFloat()
        val cy = (height / 2).toFloat()
        canvas?.drawCircle(cx, cy, (specs.diameter / 2).toFloat(), paint)
    }
}
