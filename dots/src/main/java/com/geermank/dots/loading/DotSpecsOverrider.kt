package com.geermank.dots.loading

import com.geermank.dots.loading.view.DotLoadingSpecs

internal interface DotSpecsOverrider {
    fun overrideSpecs(specs: DotLoadingSpecs)
}