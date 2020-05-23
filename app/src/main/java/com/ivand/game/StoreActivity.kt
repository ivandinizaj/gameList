package com.ivand.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivand.game.adapter.AdapterGames
import com.ivand.game.adapter.AdapterStore
import com.ivand.game.commos.BaseActivity
import com.ivand.game.model.Console
import com.ivand.game.model.Game
import com.ivand.game.utilies.Constants.EXTRA_CONSOLE
import com.ivand.game.utilies.extensions.disabled
import com.ivand.game.utilies.extensions.enabled
import com.ivand.game.utilies.extensions.gone
import kotlinx.android.synthetic.main.activity_store.*
import java.text.MessageFormat

class StoreActivity : BaseActivity(), AdapterStore.ListenerClick {

    private lateinit var mConsole: Console
    private lateinit var mAdapterGames: AdapterStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)


        mConsole = intent?.getParcelableExtra(EXTRA_CONSOLE) as Console
        initialize(getString(R.string.store_title), mConsole.name, TRANSITION_HORIZONTAL, true)
        initView()

    }

    private fun initView() {
        mAdapterGames = AdapterStore(mConsole.games, this@StoreActivity) {
            if (!it) {
                txtListEmpty.gone()
            } else
                listGames.gone()
        }

        listGames.apply {
            adapter = mAdapterGames
            layoutManager = GridLayoutManager(this@StoreActivity, 1)
        }

        btnStore.disabled()
    }

    private fun validate(){
        val value = mAdapterGames.getItemsSelected().size
        if(value == 0)
            btnStore.disabled()
        else
            btnStore.enabled()
    }

    override fun onItemClick(game: Game) {
        val value = mAdapterGames.getItemsSelected().size
        btnStore.text = resources.getQuantityString(R.plurals.store_button_purchase, value + 1, value)
        validate()
    }

    companion object {
        fun newIntent(context: Context, console: Console): Intent {
            val i = Intent(context, StoreActivity::class.java)
            return i.putExtra(EXTRA_CONSOLE, console)
        }
    }

}
