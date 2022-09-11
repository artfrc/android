package com.androiddev.videoapp

import android.net.Uri
import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.androiddev.videoapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        var videoView = binding.videoView
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val uri : Uri = parse("android.resource://"+packageName+"/"+R.raw.video)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()


    }
}