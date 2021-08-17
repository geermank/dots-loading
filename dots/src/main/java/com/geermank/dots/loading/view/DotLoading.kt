package com.geermank.dots.loading.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.core.view.children
import com.geermank.dots.R
import com.geermank.dots.dot.Dot
import com.geermank.dots.extensions.generateNewId
import com.geermank.dots.loading.DotLoadingsFactoryMapper
import com.geermank.dots.loading.DotsLoadingSizeTypes
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.loading.DotsModifiersFactoryType
import com.geermank.dots.utils.ViewSize

internal const val DEFAULT_NUMBER_OF_DOTS = 3

class DotLoading @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var specs: DotLoadingSpecs
    private var dotsModifiersFactory: DotsModifiersFactory

    init {
        DotLoadingAttributeExtractor(attrs, context).run {
            dotsModifiersFactory = createDotsModifierFactory()
            specs = DotLoadingSpecs(
                getLoadingContainerSize(dotsModifiersFactory.requiresHorizontalContainer()),
                getDotSize(),
                getDotsColor(),
                getNumberOfDotsToDraw(DEFAULT_NUMBER_OF_DOTS)
            )
            finish()
        }

        createDotsAndAddItToParent()
        calculateAndSetDotsPositions()
    }

    internal constructor(context: Context, specs: DotLoadingSpecs, dotsModifiersFactory: DotsModifiersFactory) : this(context) {
        this.specs = specs
        this.dotsModifiersFactory = dotsModifiersFactory

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
            val dot = Dot(context, specs.createDotSpecs()).also {
                if (index == 1) {
                    it.setColor(android.R.color.black)
                }
            }
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

    class Builder(private val context: Context) {

        private val dotLoadingSpecs = DotLoadingSpecs()
        private var dotsModifierFactory: DotsModifiersFactory = DotsModifiersFactory.DEFAULT

        fun setLoadingType(@DotsModifiersFactoryType index: Int): Builder {
            dotsModifierFactory = DotLoadingsFactoryMapper.getByIndex(index)
            return this
        }

        fun setDotColor(@ColorRes color: Int): Builder {
            dotLoadingSpecs.dotColor = color
            return this
        }

        fun setLoadingSize(@DotsLoadingSizeTypes index: Int): Builder {
            val dotLoadingSize = DotLoadingSizeFactory.getFromIndexOrDefault(index)
            dotLoadingSpecs.dotSize = ViewSize(dotLoadingSize.getDotSizeFromDimens(context))
            dotLoadingSpecs.containerSize = ViewSize(dotLoadingSize.getContainerSizeFromDimens(context))
            return this
        }

        fun setNumberOfDots(numberOfDots: Int): Builder {
            dotLoadingSpecs.numberOfDots = numberOfDots
            return this
        }

        fun build(): DotLoading {
            return DotLoading(context, dotLoadingSpecs, dotsModifierFactory).also { it.generateNewId() }
        }
    }
}
