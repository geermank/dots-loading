package com.geermank.dots.loading.linear

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory

internal class LinearModifierFactory : DotsModifiersFactory {

    override fun createDotsAnimation(): DotsAnimation {
        return LinearDotsAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return LinearDotPositionDecider()
    }

    override fun requiresHorizontalContainer(): Boolean {
        return true
    }
}
