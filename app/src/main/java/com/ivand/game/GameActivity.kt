package com.ivand.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ivand.game.adapter.AdapterGames
import com.ivand.game.commos.BaseActivity
import com.ivand.game.model.Console
import com.ivand.game.model.Game
import com.ivand.game.utilies.Constants
import com.ivand.game.utilies.SpacesItemDecoration
import com.ivand.game.utilies.extensions.contCalculateNoOfColumns
import com.ivand.game.utilies.extensions.gone
import com.ivand.game.utilies.extensions.toast
import kotlinx.android.synthetic.main.activity_games.listGames
import kotlinx.android.synthetic.main.activity_games.txtListEmpty

class GameActivity : BaseActivity(), AdapterGames.ListenerClick {

    private lateinit var mConsole: Console

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        mConsole = intent?.getParcelableExtra(Constants.EXTRA_CONSOLE) as Console

        initialize(getString(R.string.games_title), mConsole.name, TRANSITION_HORIZONTAL, true)

        initView()
    }

    private fun initView() {
        val games = AdapterGames(mConsole.games, this@GameActivity) {
            if (!it)
                txtListEmpty.gone()
            else
                listGames.gone()
        }

        listGames.apply {
            adapter = games
            layoutManager = StaggeredGridLayoutManager(
                contCalculateNoOfColumns(150f),
                StaggeredGridLayoutManager.VERTICAL
            );
            addItemDecoration(SpacesItemDecoration(16))
        }
    }

    override fun onItemClick(game: Game) {
        toast(game.name)
    }

    companion object {
        fun newIntent(context: Context, console: Console): Intent {
            val intent = Intent(context, GameActivity::class.java)
            return intent.putExtra(Constants.EXTRA_CONSOLE, console)
        }
    }

}
