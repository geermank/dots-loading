package com.geermank.dots.loading.tiktok

import com.geermank.dots.loading.DotSpecsOverrider
import com.geermank.dots.loading.view.DotLoadingSpecs

private const val TIK_TOK_ANIMATION_NUMBER_OF_DOTS = 2

internal class TikTokDotSpecsOverrider : DotSpecsOverrider {

    override fun overrideSpecs(specs: DotLoadingSpecs) {
        specs.numberOfDots = TIK_TOK_ANIMATION_NUMBER_OF_DOTS
    }
}
