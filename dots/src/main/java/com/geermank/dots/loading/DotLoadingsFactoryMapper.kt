package com.geermank.dots.loading

import com.geermank.dots.loading.bouncing.BouncingModifierFactory
import com.geermank.dots.loading.circular.CircularProgressModifiersFactory
import com.geermank.dots.loading.linear.LinearModifierFactory
import com.geermank.dots.loading.orbit.OrbitModifiersFactory

internal class DotLoadingsFactoryMapper {

    private val styles = mapOf(
        Pair(DotLoadings.CIRCULAR, CircularProgressModifiersFactory()),
        Pair(DotLoadings.ORBIT, OrbitModifiersFactory()),
        Pair(DotLoadings.LINEAR, LinearModifierFactory()),
        Pair(DotLoadings.BOUNCING, BouncingModifierFactory())
    )

    fun getByKey(key: DotLoadings): DotsModifiersFactory {
        return styles[key] ?: NoModifierFactory()
    }
}
