package com.geermank.dots.loading.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.view.children
import com.geermank.dots.R
import com.geermank.dots.dot.Dot
import com.geermank.dots.extensions.getDimenPixelSize
import com.geermank.dots.loading.DotLoadingSize
import com.geermank.dots.loading.DotLoadingTypes
import com.geermank.dots.loading.DotLoadingsFactoryMapper
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.utils.ViewSize

internal const val DEFAULT_NUMBER_OF_DOTS = 3

class DotLoading @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val specs: DotLoadingSpecs
    private var dotsModifiersFactory: DotsModifiersFactory

    init {
        DotLoadingAttributeExtractor(attrs, context).run {
            dotsModifiersFactory = createDotsModifierFactory()
            specs = DotLoadingSpecs(
                getLoadingContainerSize(dotsModifiersFactory.requiresHorizontalContainer()),
                getDotSize(),
                getNumberOfDotsToDraw()
            )
            finish()
        }

        createDotsAndAddItToParent()
        calculateAndSetDotsPositions()
    }

    internal fun getSizeInPixels() = specs.containerSize

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(specs.getContainerWidthInPixels(), specs.getContainerHeightInPixels())
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateDots()
    }

    private fun createDotsAndAddItToParent() {
        for (index in 0 until specs.numberOfDots) {
            val dot = Dot(context, specs.dotSize)
            addView(dot)
        }
    }

    private fun calculateAndSetDotsPositions() {
        children.forEachIndexed { index, dot ->
            val dotsPositionDecider = dotsModifiersFactory.createDotsPositionDecider()
            val coordinates = dotsPositionDecider.getPosition(index, dot as Dot, specs)

            dot.x = coordinates.getX().toFloat()
            dot.y = coordinates.getY().toFloat()
        }
    }

    private fun animateDots() {
        val dotAnimation = dotsModifiersFactory.createDotsAnimation()
        children.forEachIndexed { index, view ->
            dotAnimation.animateDot(this, view as Dot, index)
        }
    }
}
