package com.geermank.dots.loading.tiktok

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotSpecsOverrider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory

internal class TikTokModifiersFactory : DotsModifiersFactory {

    override fun createDotsAnimation(): DotsAnimation {
        return TikTokDotAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return TikTokDotPositionDecider()
    }

    override fun createDotSpecsOverrider(): DotSpecsOverrider {
        return TikTokDotSpecsOverrider()
    }

    override fun requiresHorizontalContainer(): Boolean {
        return false
    }
}
