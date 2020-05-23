package com.ivand.game.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivand.game.R
import com.ivand.game.model.Console

class AdapterConsoles(
    var mList: ArrayList<Console>,
    private var listenerClick: ListenerClick,
    listenerEmpty: (isEmpty: Boolean) -> Unit
) : RecyclerView.Adapter<AdapterConsoles.MyViewHolder>() {

    init {
        listenerEmpty(mList.isEmpty())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_console, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val console = mList[position]

        viewHolder.txtName.text = console.name
        viewHolder.imgCover.setImageResource(console.imageResource)

        viewHolder.itemView.setOnClickListener {
            listenerClick.onItemClick(console)
        }
    }

    override fun getItemCount(): Int = mList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgCover: ImageView = itemView.findViewById(R.id.imgCover)
        var txtName: TextView = itemView.findViewById(R.id.txtName)
    }

    interface ListenerClick {
        fun onItemClick(console: Console)
    }
}

