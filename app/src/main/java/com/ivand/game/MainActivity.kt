package com.ivand.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivand.game.adapter.AdapterConsoles
import com.ivand.game.model.Console
import com.ivand.game.model.Game
import com.ivand.game.model.datas.getConsoles
import com.ivand.game.utilies.extensions.gone
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterConsoles.ListenerClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        initList()
    }

    private fun initList() {

        val adapter = AdapterConsoles(getConsoles(), this@MainActivity) {
            if(!it) {
                txtListEmpty.gone()
            }else
                listConsole.gone()
        }

        listConsole.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }

    }

    override fun onItemClick(console: Console) {
        startActivity(MenuConsoleActivity.newIntent(this, console))
    }

}
