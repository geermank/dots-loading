package com.geermank.dots.loading.view

import android.content.Context
import androidx.annotation.DimenRes
import com.geermank.dots.R
import com.geermank.dots.extensions.getDimenPixelSize
import com.geermank.dots.loading.DotsLoadingSizeTypes

internal sealed class DotLoadingSize(
    @DimenRes private val containerSize: Int,
    @DimenRes private val dotSize: Int
) {

    companion object {
        val DEFAULT = LargeLoadingSize()
    }

    fun getContainerSizeFromDimens(context: Context): Int {
        return context.getDimenPixelSize(containerSize)
    }

    fun getDotSizeFromDimens(context: Context): Int {
        return context.getDimenPixelSize(dotSize)
    }
}

internal class SmallLoadingSize : DotLoadingSize(R.dimen.small_dot_loading_size, R.dimen.small_dot_diameter)
internal class LargeLoadingSize : DotLoadingSize(R.dimen.large_dot_loading_size, R.dimen.large_dot_diameter)

internal object DotLoadingSizeFactory {

    private val values = mapOf(
        Pair(DotsLoadingSizeTypes.SMALL, SmallLoadingSize()),
        Pair(DotsLoadingSizeTypes.LARGE, LargeLoadingSize())
    )

    fun getFromIndexOrDefault(@DotsLoadingSizeTypes index: Int): DotLoadingSize {
        return values.getOrElse(index) { DotLoadingSize.DEFAULT }
    }
}
