package com.ivand.game.commos

import android.annotation.SuppressLint
import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.ivand.game.R

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    enum class Slide(val value: Pair<Int, Int>) {
        SLIDE_HORIZONTAL(R.anim.slide_in_right to R.anim.slide_out_right),
        SLIDE_VERTICAL(R.anim.slide_in_right to R.anim.slide_out_right)
    }

    companion object {
        const val TRANSITION_HORIZONTAL = "transition_horizontal"
        const val TRANSITION_VERTICAL = "transition_vertical"
        const val TRANSITION_NONE = "none"
    }

    fun initialize(
        mTitle: String?,
        transition: String = TRANSITION_HORIZONTAL,
        setDisplayHome: Boolean = true
    ) {
        transitionActivity(transition)
        actionBar(setDisplayHome, mTitle)
    }

    fun initialize(
        mTitle: String?,
        mSubTitle: String?,
        transition: String = TRANSITION_HORIZONTAL,
        setDisplayHome: Boolean = true
    ) {
        transitionActivity(transition)
        actionBar(setDisplayHome, mTitle, mSubTitle)
    }

    private fun actionBar(setDisplayHome: Boolean, text: String?, subTitle: String? = ""){
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(setDisplayHome)
            title = text ?: getString(R.string.app_name)
            subtitle = subTitle ?: ""
        }
    }

    private fun transitionActivity(transition: String){
        if (transition != TRANSITION_NONE)
            when (transition) {
                TRANSITION_HORIZONTAL ->
                    overridePendingTransition(
                        Slide.SLIDE_HORIZONTAL.value.first,
                        R.anim.stay
                    )
                TRANSITION_VERTICAL ->
                    overridePendingTransition(
                        Slide.SLIDE_VERTICAL.value.first,
                        R.anim.stay
                    )
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_right)
    }
}