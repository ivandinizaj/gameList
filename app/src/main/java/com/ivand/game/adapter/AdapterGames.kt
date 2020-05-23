package com.ivand.game.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ivand.game.R
import com.ivand.game.model.Game
import com.ivand.game.utilies.extensions.gone

class AdapterGames(
    var mList: List<Game>,
    private var listenerClick: ListenerClick,
    listenerEmpty: (isEmpty: Boolean) -> Unit
) : RecyclerView.Adapter<AdapterGames.MyViewHolder>() {

    init {
        listenerEmpty(mList.isEmpty())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_game, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val game = mList[position]

        viewHolder.txtName.text = game.name

        Glide.with(viewHolder.itemView)
            .load(game.image)
            .fitCenter()
            .listener(object : RequestListener<Drawable> {

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    viewHolder.prbImage.gone()
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    viewHolder.prbImage.gone()
                    return false
                }
            })
            .into(viewHolder.imgCover)

        viewHolder.itemView.setOnClickListener {
            listenerClick.onItemClick(game)
        }
    }

    override fun getItemCount(): Int = mList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
        var imgCover: ImageView = itemView.findViewById(R.id.imgCover)
        var prbImage: ProgressBar = itemView.findViewById(R.id.prbImage)
    }

    interface ListenerClick {
        fun onItemClick(game: Game)
    }
}

