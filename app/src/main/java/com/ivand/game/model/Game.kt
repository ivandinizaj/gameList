package com.ivand.game.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val name: String,
    val image: String,
    var selected: Boolean = false
) : Parcelable