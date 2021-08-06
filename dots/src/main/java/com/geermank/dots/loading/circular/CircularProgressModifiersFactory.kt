package com.geermank.dots.loading.circular

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory

internal open class CircularProgressModifiersFactory : DotsModifiersFactory {

    override fun createDotsAnimation(): DotsAnimation {
        return CircularProgressAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return CircularProgressDotPositionDecider()
    }
}