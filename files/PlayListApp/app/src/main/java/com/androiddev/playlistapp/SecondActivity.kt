package com.androiddev.playlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androiddev.playlistapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }
}