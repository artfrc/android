package com.androiddev.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androiddev.firstapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent.getStringExtra("TYPE_USER")

        binding.tvMessage.text = "Congratulations $name!"

    }
}