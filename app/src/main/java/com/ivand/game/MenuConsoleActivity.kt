package com.ivand.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivand.game.adapter.AdapterMenuConsole
import com.ivand.game.commos.BaseActivity
import com.ivand.game.model.Console
import com.ivand.game.utilies.Constants.EXTRA_CONSOLE
import com.ivand.game.utilies.extensions.toast
import kotlinx.android.synthetic.main.activity_menu_console.*

class MenuConsoleActivity : BaseActivity(), AdapterMenuConsole.ListenerClick {

    private lateinit var mConsole: Console

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_console)

        initialize(getString(R.string.menu_console_title), TRANSITION_HORIZONTAL, true)

        mConsole = intent?.getParcelableExtra(EXTRA_CONSOLE) as Console

        initView()
    }

    private fun initView() {
        initList()
    }

    private fun initList() {

        val adapter = AdapterMenuConsole(getMenu(), this) {
        }

        listMenu.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MenuConsoleActivity)
            addItemDecoration(DividerItemDecoration(this@MenuConsoleActivity, DividerItemDecoration.VERTICAL))
        }
    }

    private fun getMenu(): List<String> {
        return resources.getStringArray(R.array.menu_console).toList()
    }

    override fun onItemClick(menu: String) {
        val listMenu = getMenu()
        when(menu){
            listMenu[0] -> startActivity(DetailsActivity.newIntent(this,mConsole))
            listMenu[1] -> startActivity(GameActivity.newIntent(this, mConsole))
            listMenu[2] -> startActivity(StoreActivity.newIntent(this, mConsole))
            else ->
                toast(getString(R.string.item_not_found_generic))
        }
    }

    companion object {
        fun newIntent(context: Context, console: Console): Intent {
            val i = Intent(context, MenuConsoleActivity::class.java)
            return i.putExtra(EXTRA_CONSOLE, console)
        }
    }

}
