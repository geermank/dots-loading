package com.geermank.dots.loading.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.core.view.children
import com.geermank.dots.dot.Dot
import com.geermank.dots.dot.color.MultipleColorsDotPainter
import com.geermank.dots.dot.color.SingleColorDotPainter
import com.geermank.dots.extensions.generateNewId
import com.geermank.dots.loading.DotLoadingsFactoryMapper
import com.geermank.dots.loading.DotsLoadingSizeTypes
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.loading.DotsModifiersFactoryType
import com.geermank.dots.utils.ViewSize

internal const val DEFAULT_NUMBER_OF_DOTS = 3

class DotLoading : FrameLayout {

    private var specs: DotLoadingSpecs
    private var dotsModifiersFactory: DotsModifiersFactory

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val attributeExtractor = DotLoadingAttributeExtractor(attrs, context)
        attributeExtractor.run {
            dotsModifiersFactory = createDotsModifierFactory()
            specs = DotLoadingSpecs(
                    getLoadingContainerSize(dotsModifiersFactory.requiresHorizontalContainer()),
                    getDotSize(),
                    getDotColorPainter(),
                    getNumberOfDotsToDraw(DEFAULT_NUMBER_OF_DOTS)
            )
            finish()
        }
        makeInitialSetUp()
    }

    internal constructor(context: Context, specs: DotLoadingSpecs, dotsModifiersFactory: DotsModifiersFactory) : super(context) {
        this.dotsModifiersFactory = dotsModifiersFactory
        this.specs = specs
        makeInitialSetUp()
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

    private fun makeInitialSetUp() {
        overrideCalculatedSpecsIfNeeded()
        createDotsAndAddItToParent()
        calculateAndSetDotsPositions()
    }

    private fun overrideCalculatedSpecsIfNeeded() {
        dotsModifiersFactory.createDotSpecsOverrider()?.overrideSpecs(specs)
    }

    private fun createDotsAndAddItToParent() {
        for (index in 0 until specs.numberOfDots) {
            val dot = Dot(context, specs.createDotSpecs(index))
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

        fun setDotPrimaryColor(@ColorRes color: Int): Builder {
            dotLoadingSpecs.dotPainter = SingleColorDotPainter(color)
            return this
        }

        fun setDotMultipleColors(@ColorRes primaryColor: Int?, @ArrayRes colors: IntArray): Builder {
            dotLoadingSpecs.dotPainter = MultipleColorsDotPainter(primaryColor, colors)
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
