package com.geermank.dots.loading.view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.geermank.dots.R
import com.geermank.dots.loading.DotLoadingSize
import com.geermank.dots.loading.DotLoadingSizeFactory
import com.geermank.dots.loading.DotLoadingTypes
import com.geermank.dots.loading.DotLoadingsFactoryMapper
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.utils.ViewSize

internal class DotLoadingAttributeExtractor(
    attrs: AttributeSet?,
    private val context: Context
) {

    private val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DotLoading)

    fun createDotsModifierFactory(): DotsModifiersFactory {
        val valuesMapper = DotLoadingsFactoryMapper()
        val key = DotLoadingTypes.values()[typedArray.getInt(R.styleable.DotLoading_loadingType, 0)]
        return valuesMapper.getByKey(key)
    }

    fun getLoadingContainerSize(requiresHorizontalContainer: Boolean): ViewSize {
        val loadingSize = getLoadingSize()
        val width = loadingSize.getContainerSizeFromDimens(context)
        val height = if (requiresHorizontalContainer) {
            // when container is horizontal, the height will be enough
            // to contain a dot's height with some margins
            getDotSize(loadingSize).getSmallest() * 2
        } else {
            // are always equals. The only case when they aren't is
            // when container should be horizontal
            width
        }
        return ViewSize(width, height)
    }

    fun getDotSize(calculatedSize: DotLoadingSize? = null): ViewSize {
        val dotLoadingSize = calculatedSize ?: getLoadingSize()
        val dotSizeInPixels = dotLoadingSize.getDotSizeFromDimens(context)
        return ViewSize(dotSizeInPixels, dotSizeInPixels)
    }

    fun getNumberOfDotsToDraw(default: Int): Int {
        return if (typedArray.hasValue(R.styleable.DotLoading_numberOfDots)) {
            typedArray.getInt(R.styleable.DotLoading_numberOfDots, DEFAULT_NUMBER_OF_DOTS)
        } else {
            default
        }
    }


    fun getDotsColor(): Int {
        return typedArray.getResourceId(R.styleable.DotLoading_dotsColor, -1)
    }

    fun finish() {
        typedArray.recycle()
    }

    private fun getLoadingSize(): DotLoadingSize {
        val loadingSizeIndex = typedArray.getInt(R.styleable.DotLoading_loadingSize, -1)
        return DotLoadingSizeFactory.getFromIndexOrDefault(loadingSizeIndex)
    }
}
