package com.geermank.dots.loading.circular.path

internal abstract class CircularProgressMovementDirection(protected val value: Int) {
    abstract fun applyOnAngle(angle: Float): Float
}

internal class ClockwiseDirection : CircularProgressMovementDirection(1) {

    override fun applyOnAngle(angle: Float): Float {
        return angle * value
    }
}

internal class CounterClockwiseDirection : CircularProgressMovementDirection(-1) {

    override fun applyOnAngle(angle: Float): Float {
        return angle * value
    }
}