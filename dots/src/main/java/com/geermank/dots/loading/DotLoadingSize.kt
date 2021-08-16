package com.geermank.dots.loading

import android.content.Context
import androidx.annotation.DimenRes
import com.geermank.dots.R
import com.geermank.dots.extensions.getDimenPixelSize

internal sealed class DotLoadingSize(
    @DimenRes private val containerSize: Int,
    @DimenRes private val dotSize: Int
) {

    companion object {
        val DEFAULT = LargeLoadingSize()
    }

    @DimenRes
    fun getContainerSizeFromDimens(context: Context): Int {
        return context.getDimenPixelSize(containerSize)
    }

    @DimenRes
    fun getDotSizeFromDimens(context: Context): Int {
        return context.getDimenPixelSize(dotSize)
    }
}

internal class SmallLoadingSize : DotLoadingSize(R.dimen.small_dot_loading_size, R.dimen.small_dot_diameter)
internal class LargeLoadingSize : DotLoadingSize(R.dimen.large_dot_loading_size, R.dimen.large_dot_diameter)

internal object DotLoadingSizeFactory {

    private val values = mapOf(
        Pair(0, SmallLoadingSize()),
        Pair(1, LargeLoadingSize())
    )

    fun getFromIndexOrDefault(index: Int): DotLoadingSize {
        return values.getOrElse(index) { DotLoadingSize.DEFAULT }
    }
}
