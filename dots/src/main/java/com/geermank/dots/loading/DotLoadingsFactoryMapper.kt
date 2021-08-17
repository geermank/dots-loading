package com.geermank.dots.loading

import com.geermank.dots.loading.bouncing.BouncingModifierFactory
import com.geermank.dots.loading.circular.CircularProgressModifiersFactory
import com.geermank.dots.loading.linear.LinearModifierFactory
import com.geermank.dots.loading.orbit.OrbitModifiersFactory

internal object DotLoadingsFactoryMapper {

    private val modifierFactoriesMap = mapOf(
        Pair(0, CircularProgressModifiersFactory()),
        Pair(1, OrbitModifiersFactory()),
        Pair(2, LinearModifierFactory()),
        Pair(3, BouncingModifierFactory())
    )

    fun getByIndex(index: Int): DotsModifiersFactory {
        return modifierFactoriesMap.getOrElse(index) { DotsModifiersFactory.DEFAULT }
    }
}
