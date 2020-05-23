package com.ivand.game.utilies.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Calcula o número de coluna de acordo com o tamanho da tela
 */
fun Context.contCalculateNoOfColumns(
    columnWidthDp: Float = 150f
): Int {
   return resources.displayMetrics.run {
        val screenWidthDp =  this.widthPixels / this.density
       (screenWidthDp / columnWidthDp + 0.5)
    }.toInt()
}