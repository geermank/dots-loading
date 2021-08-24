package com.geermank.dots.loading

import androidx.annotation.IntDef
import com.geermank.dots.loading.DotLoadingTypes.Companion.BOUNCE
import com.geermank.dots.loading.DotLoadingTypes.Companion.CIRCULAR
import com.geermank.dots.loading.DotLoadingTypes.Companion.FLIP
import com.geermank.dots.loading.DotLoadingTypes.Companion.LINEAR
import com.geermank.dots.loading.DotLoadingTypes.Companion.ORBIT
import com.geermank.dots.loading.DotLoadingTypes.Companion.TIK_TOK

@IntDef(CIRCULAR, ORBIT, LINEAR, BOUNCE, TIK_TOK, FLIP)
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class DotLoadingTypes {

    companion object {
        const val CIRCULAR = 0
        const val ORBIT = 1
        const val LINEAR = 2
        const val BOUNCE = 3
        const val TIK_TOK = 4
        const val FLIP = 5
    }
}
