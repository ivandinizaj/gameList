package com.ivand.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ivand.game.commos.BaseActivity
import com.ivand.game.model.Console
import com.ivand.game.utilies.Constants
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity() {

    private lateinit var mConsole: Console

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mConsole = intent?.getParcelableExtra(Constants.EXTRA_CONSOLE) as Console

        initialize(getString(R.string.details_title), mConsole.name, TRANSITION_HORIZONTAL, true)

        initView()
    }

    private fun initView() {
        with(mConsole) {
            txtTitle.text = this.name
            txtDescription.text = this.description
            imageConsole.setImageResource(this.imageResource)
        }
    }

    companion object {
        fun newIntent(context: Context, console: Console): Intent {
            val i = Intent(context, DetailsActivity::class.java)
            return i.putExtra(Constants.EXTRA_CONSOLE, console)
        }
    }

}
