package com.ivand.game.utilies.extensions

import android.view.View
import android.widget.Button

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hidden() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Button.disabled(){
    with(this) {
        isEnabled = false
        alpha = 0.75f
    }
}

fun Button.enabled(){
    with(this) {
        isEnabled = true
        alpha = 1f
    }
}