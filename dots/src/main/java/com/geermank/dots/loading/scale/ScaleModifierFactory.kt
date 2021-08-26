package com.geermank.dots.loading.scale

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.loading.commons.position.NextToEachOtherCenteredPositionDecider

internal class ScaleModifierFactory : DotsModifiersFactory {

    override fun requiresHorizontalContainer(): Boolean {
        return true
    }

    override fun createDotsAnimation(): DotsAnimation {
        return ScaleDotAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return NextToEachOtherCenteredPositionDecider()
    }
}
