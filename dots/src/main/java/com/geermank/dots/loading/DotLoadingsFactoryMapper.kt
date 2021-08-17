package com.geermank.dots.loading

import com.geermank.dots.loading.bouncing.BouncingModifierFactory
import com.geermank.dots.loading.circular.CircularProgressModifiersFactory
import com.geermank.dots.loading.linear.LinearModifierFactory
import com.geermank.dots.loading.orbit.OrbitModifiersFactory

object DotLoadingsFactoryMapper {

    private val modifierFactoriesMap = mapOf(
        Pair(DotsModifiersFactoryType.CIRCULAR, CircularProgressModifiersFactory()),
        Pair(DotsModifiersFactoryType.ORBIT, OrbitModifiersFactory()),
        Pair(DotsModifiersFactoryType.LINEAR, LinearModifierFactory()),
        Pair(DotsModifiersFactoryType.BOUNCE, BouncingModifierFactory())
    )

    internal fun getByIndex(@DotsModifiersFactoryType index: Int): DotsModifiersFactory {
        return modifierFactoriesMap.getOrElse(index) { DotsModifiersFactory.DEFAULT }
    }
}
