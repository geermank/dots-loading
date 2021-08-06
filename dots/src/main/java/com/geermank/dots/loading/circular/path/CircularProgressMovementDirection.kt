package com.geermank.dots.loading.circular.path

abstract class CircularProgressMovementDirection(protected val value: Int) {
    abstract fun applyOnAngle(angle: Float): Float
}

class ClockwiseDirection : CircularProgressMovementDirection(1) {

    override fun applyOnAngle(angle: Float): Float {
        return angle * value
    }
}

class CounterClockwiseDirection : CircularProgressMovementDirection(-1) {

    override fun applyOnAngle(angle: Float): Float {
        return angle * value
    }
}