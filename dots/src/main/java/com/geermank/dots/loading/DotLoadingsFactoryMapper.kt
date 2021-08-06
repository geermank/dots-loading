package com.geermank.dots.loading

import com.geermank.dots.loading.bouncing.BouncingModifierFactory
import com.geermank.dots.loading.circular.CircularProgressModifiersFactory
import com.geermank.dots.loading.linear.LinearModifierFactory
import com.geermank.dots.loading.orbit.OrbitModifiersFactory

internal class DotLoadingsFactoryMapper {

    private val styles = mapOf(
        Pair(DotLoadingTypes.CIRCULAR, CircularProgressModifiersFactory()),
        Pair(DotLoadingTypes.ORBIT, OrbitModifiersFactory()),
        Pair(DotLoadingTypes.LINEAR, LinearModifierFactory()),
        Pair(DotLoadingTypes.BOUNCING, BouncingModifierFactory())
    )

    fun getByKey(key: DotLoadingTypes): DotsModifiersFactory {
        return styles[key] ?: NoModifierFactory()
    }
}
