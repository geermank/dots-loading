package com.geermank.dots.loading.orbit

import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.circular.CircularProgressAnimation
import com.geermank.dots.loading.circular.CircularProgressModifiersFactory

internal class OrbitModifiersFactory : CircularProgressModifiersFactory() {

    override fun createDotsAnimation(): DotsAnimation {
        return CircularProgressAnimation(OrbitPathCalculator())
    }
}
