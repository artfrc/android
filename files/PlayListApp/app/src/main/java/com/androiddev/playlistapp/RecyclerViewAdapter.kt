package com.androiddev.playlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class RecyclerViewAdapter(
    private val musicList : List<Music>,
    private val clickListener :(Music)->Unit
    ) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(musicList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){

    fun bind(music : Music, clickListener : (Music)->Unit) {
        val tvMusic = view.findViewById<TextView>(R.id.tvMusic)
        tvMusic.text = music.name

        val tvArtist = view.findViewById<TextView>(R.id.tvArtist)
        tvArtist.text = music.artist

        val tvDuration = view.findViewById<TextView>(R.id.tvDuration)
        tvDuration.text = music.duration

        view.setOnClickListener{
            clickListener(music)
        }

    }

}