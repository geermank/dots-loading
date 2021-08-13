package com.geermank.dots.utils

private const val X_COORDINATE_INDEX = 0
private const val Y_COORDINATE_INDEX = 1

internal class Coordinates(x: Double, y: Double) {

    private val values = DoubleArray(2)

    init {
        values[X_COORDINATE_INDEX] = x
        values[Y_COORDINATE_INDEX] = y
    }

    fun setX(value: Double) {
        saveValue(value, X_COORDINATE_INDEX)
    }

    fun setY(value: Double) {
        saveValue(value, Y_COORDINATE_INDEX)
    }

    fun getX(): Double {
        return getValue(X_COORDINATE_INDEX)
    }

    fun getY(): Double {
        return getValue(Y_COORDINATE_INDEX)
    }

    private fun saveValue(value: Double, index: Int) {
        values[index] = value
    }

    private fun getValue(index: Int): Double {
        return values[index]
    }
}
