package com.ivand.game.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivand.game.R
import com.ivand.game.model.Console

class AdapterMenuConsole(
    var mList: List<String>,
    private var listenerClick: ListenerClick,
    listenerEmpty: (isEmpty: Boolean) -> Unit
) : RecyclerView.Adapter<AdapterMenuConsole.MyViewHolder>() {

    init {
        listenerEmpty(mList.isEmpty())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_menu_console, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val menu = mList[position]

        viewHolder.txtName.text = menu

        viewHolder.itemView.setOnClickListener {
            listenerClick.onItemClick(menu)
        }
    }

    override fun getItemCount(): Int = mList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
    }

    interface ListenerClick {
        fun onItemClick(menu: String)
    }
}

