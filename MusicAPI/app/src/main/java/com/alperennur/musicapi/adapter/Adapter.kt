package com.alperennur.musicapi.adapter

import android.graphics.Color
import android.inputmethodservice.Keyboard
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alperennur.musicapi.R
import com.alperennur.musicapi.databinding.RecyclerRowBinding
import com.alperennur.musicapi.model.MusicModel
import com.squareup.picasso.Picasso

class Adapter(private var musicList:ArrayList<MusicModel>):
    RecyclerView.Adapter<Adapter.RowHolder>() {

    private val colors: Array<String> = arrayOf("#212121","#212121","#212121","#212121")


    class RowHolder(val recyclerRowBinding: RecyclerRowBinding ):RecyclerView.ViewHolder(recyclerRowBinding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val recRowBinding = RecyclerRowBinding.inflate(layoutInflater,parent,false)
        return RowHolder(recRowBinding)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val music= musicList[position]

        holder.recyclerRowBinding.apply {


            artistNameText.text=music.artistName
            Picasso.get().load(music.artworkUrl100).into(trackImage)
            albumNameText.text=music.collectionName
            trackNameText.text= music.trackName
        }
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 4]))

        if (colors[position%4]==("#eeeeee")){

            holder.recyclerRowBinding.artistNameText.setTextColor(Color.parseColor("#212121"))
            holder.recyclerRowBinding.albumNameText.setTextColor(Color.parseColor("#212121"))
            holder.recyclerRowBinding.trackNameText.setTextColor(Color.parseColor("#212121"))

        }

        else if (colors[position%4]==("#212121")){

            holder.recyclerRowBinding.artistNameText.setTextColor(Color.parseColor("#eeeeee"))
            holder.recyclerRowBinding.albumNameText.setTextColor(Color.parseColor("#eeeeee"))
            holder.recyclerRowBinding.trackNameText.setTextColor(Color.parseColor("#eeeeee"))

        }




    }

    override fun getItemCount(): Int {
        return  musicList.size
    }


}