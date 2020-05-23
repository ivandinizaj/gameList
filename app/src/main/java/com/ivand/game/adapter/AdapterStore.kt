package com.ivand.game.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivand.game.R
import com.ivand.game.model.Game

class AdapterStore(
    private var mList: List<Game>,
    private var listenerClick: ListenerClick,
    listenerEmpty: (isEmpty: Boolean) -> Unit
) : RecyclerView.Adapter<AdapterStore.MyViewHolder>() {

    init {
        listenerEmpty(mList.isEmpty())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_store, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val game = mList[position]

        viewHolder.txtName.text = game.name

        Glide.with(viewHolder.itemView)
            .load(game.image)
            .centerInside()
            .into(viewHolder.imgCover)

        viewHolder.itemView.setOnClickListener {
            game.selected = !game.selected
            viewHolder.rdbSelected.isChecked = game.selected
            listenerClick.onItemClick(game)
        }
    }

    fun getItemsSelected(): List<Game>{
        return mList.filter(){
            it.selected
        }
    }

    override fun getItemCount(): Int = mList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtStoreName)
        var imgCover: ImageView = itemView.findViewById(R.id.imgStoreCover)
        var rdbSelected: RadioButton = itemView.findViewById(R.id.rdbSelected)
    }

    interface ListenerClick {
        fun onItemClick(game: Game)
    }
}

