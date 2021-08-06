package com.geermank.dots.dot

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class DotSpecs(
    var diameter: Int
) : Parcelable