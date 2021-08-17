package com.geermank.dots.loading

import androidx.annotation.IntDef
import com.geermank.dots.loading.DotsLoadingSizeTypes.Companion.LARGE
import com.geermank.dots.loading.DotsLoadingSizeTypes.Companion.SMALL

@IntDef(SMALL, LARGE)
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class DotsLoadingSizeTypes {

    companion object {
        const val SMALL = 0
        const val LARGE = 1
    }
}
