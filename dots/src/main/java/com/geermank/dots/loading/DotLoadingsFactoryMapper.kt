package com.geermank.dots.loading

import com.geermank.dots.loading.bouncing.BouncingModifierFactory
import com.geermank.dots.loading.circular.CircularProgressModifiersFactory
import com.geermank.dots.loading.flip.FlipModifierFactory
import com.geermank.dots.loading.linear.LinearModifierFactory
import com.geermank.dots.loading.orbit.OrbitModifiersFactory
import com.geermank.dots.loading.scale.ScaleModifierFactory
import com.geermank.dots.loading.tiktok.TikTokModifiersFactory

object DotLoadingsFactoryMapper {

    private val modifierFactoriesMap = mapOf(
        Pair(DotLoadingTypes.CIRCULAR, CircularProgressModifiersFactory()),
        Pair(DotLoadingTypes.ORBIT, OrbitModifiersFactory()),
        Pair(DotLoadingTypes.LINEAR, LinearModifierFactory()),
        Pair(DotLoadingTypes.BOUNCE, BouncingModifierFactory()),
        Pair(DotLoadingTypes.TIK_TOK, TikTokModifiersFactory()),
        Pair(DotLoadingTypes.FLIP, FlipModifierFactory()),
        Pair(DotLoadingTypes.SCALE, ScaleModifierFactory())
    )

    internal fun getByIndex(@DotLoadingTypes index: Int): DotsModifiersFactory {
        return modifierFactoriesMap.getOrElse(index) { DotsModifiersFactory.DEFAULT }
    }
}
