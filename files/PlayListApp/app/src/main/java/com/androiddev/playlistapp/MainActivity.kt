package com.androiddev.playlistapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.playlistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val musicList = listOf<Music>(
        Music("Music 1", "Artist 1", "3:25"),
        Music("Music 2", "Artist 2", "3:15"),
        Music("Music 3", "Artist 3", "2:25"),
        Music("Music 4", "Artist 4", "1:25"),
        Music("Music 5", "Artist 5", "4:45")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = binding.recyclerView
        recyclerView.setBackgroundColor(Color.BLACK)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(
            musicList,
        ){ selectedItem : Music ->
            listItemClicked(selectedItem)
        }

    }

    private fun listItemClicked(music : Music){

        val intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)

    }

}