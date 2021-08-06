package com.geermank.dots.loading.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.DimenRes
import androidx.core.view.children
import com.geermank.dots.R
import com.geermank.dots.dot.Dot
import com.geermank.dots.extensions.getDimenPixelSize
import com.geermank.dots.loading.DotLoadings
import com.geermank.dots.loading.DotLoadingsFactoryMapper
import com.geermank.dots.loading.DotsModifiersFactory

const val DEFAULT_NUMBER_OF_DOTS = 3

class DotLoading @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val specs: DotLoadingSpecs
    private var dotsModifiersFactory: DotsModifiersFactory

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DotLoading)

        dotsModifiersFactory = createDotsModifierFactory(typedArray)

        specs = DotLoadingSpecs(getLoadingSize(typedArray))
        updateNumberOfDotsInSpecs(typedArray)

        createDotsAndAddItToParent()
        calculateAndSetDotsPositions()

        typedArray.recycle()
    }

    fun getSizeInPixels() = specs.size

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(specs.size, specs.size)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateDots()
    }

    private fun createDotsModifierFactory(typedArray: TypedArray): DotsModifiersFactory {
        val valuesMapper = DotLoadingsFactoryMapper()
        val key = DotLoadings.values()[typedArray.getInt(R.styleable.DotLoading_loadingType, 0)]
        return valuesMapper.getByKey(key)
    }

    private fun createDotsModifierFactory(key: DotLoadings): DotsModifiersFactory {
        val valuesMapper = DotLoadingsFactoryMapper()
        return valuesMapper.getByKey(key)
    }

    @DimenRes
    private fun getLoadingSize(attrs: TypedArray): Int {
        // TODO get the size from attrs
        return getDimenPixelSize(R.dimen.large_dot_loading_size)
    }

    private fun updateNumberOfDotsInSpecs(attrs: TypedArray) {
        val numberOfDots = attrs.getInt(R.styleable.DotLoading_numberOfDots, DEFAULT_NUMBER_OF_DOTS)
        if (numberOfDots == DEFAULT_NUMBER_OF_DOTS) {
            return
        }
        specs.numberOfDots = numberOfDots
    }

    private fun createDotsAndAddItToParent() {
        for (index in 0 until specs.numberOfDots) {
            val dot = Dot(context)
            addView(dot)
        }
    }

    private fun calculateAndSetDotsPositions() {
        children.forEachIndexed { index, dot ->
            val dotsPositionDecider = dotsModifiersFactory.createDotsPositionDecider()
            val coordinates = dotsPositionDecider.getPosition(index, dot as Dot, getSizeInPixels(), childCount) // TODO remove magic number

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
