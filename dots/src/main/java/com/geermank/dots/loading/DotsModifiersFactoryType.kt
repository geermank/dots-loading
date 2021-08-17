package com.geermank.dots.loading

import androidx.annotation.IntDef
import com.geermank.dots.loading.DotsModifiersFactoryType.Companion.BOUNCE
import com.geermank.dots.loading.DotsModifiersFactoryType.Companion.CIRCULAR
import com.geermank.dots.loading.DotsModifiersFactoryType.Companion.LINEAR
import com.geermank.dots.loading.DotsModifiersFactoryType.Companion.ORBIT

@IntDef(CIRCULAR, ORBIT, LINEAR, BOUNCE)
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class DotsModifiersFactoryType {

    companion object {
        const val CIRCULAR = 0
        const val ORBIT = 1
        const val LINEAR = 2
        const val BOUNCE = 3
    }
}
