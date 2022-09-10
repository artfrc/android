package com.androiddev.audioproject

import android.media.MediaPlayer
import android.net.Uri
import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.MediaController
import android.widget.SeekBar
import android.widget.VideoView
import com.androiddev.audioproject.databinding.ActivityMainBinding
import java.net.URI

//    +-------------------------------------------------------------------------+
//    |   Primeiro foi criado um diretório chamado "raw"                        |
//    |   E depois foi adicionado o arquivo de audio dentro da pasta            |
//    +-------------------------------------------------------------------------+

class MainActivity : AppCompatActivity() {

    private var mediaPlayer : MediaPlayer? = null

    private lateinit var runnable: Runnable // usado na criação do Seek Bar
    private lateinit var seekBar : SeekBar
    private lateinit var binding: ActivityMainBinding
    private lateinit var handler : Handler // usado na criação do Seek Bar
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        seekBar = binding.seekBar
        handler = Handler(Looper.getMainLooper())
        var tvPlay = binding.tvPlayed
        var tvDue = binding.tvDue

//        +---------------------------+
//        |         Video             |
//        +---------------------------+

        videoView = binding.videoView

        //        +---------------------------+
//                |         Audio             |
//                +---------------------------+



        val playButton = binding.floatingActionButtonPlay
        playButton.setOnClickListener{

            if(mediaPlayer == null || videoView == null){

                mediaPlayer = MediaPlayer.create(this, R.raw.music)
                mediaPlayer?.setVolume(0F,0F)
                initializeSeekBar()

                //        +---------------------------+
//                        |         Video             |
//                        +---------------------------+
                val mediaController = MediaController(this)
                mediaController.setAnchorView(videoView)
                val uri : Uri = parse("android.resource://"+packageName+"/"+R.raw.video)
                videoView.setMediaController(mediaController)
                videoView.setVideoURI(uri)
                videoView.requestFocus()

            }

            mediaPlayer?.start()
            videoView.start()

        }

        val pauseButton = binding.floatingActionButtonPause
        pauseButton.setOnClickListener{

            mediaPlayer?.pause()
            videoView.pause()

        }

        val stopButton = binding.floatingActionButtonStop
        stopButton.setOnClickListener{

            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
            handler.removeCallbacks(runnable)
            seekBar.progress = 0
            videoView.stopPlayback()
            tvPlay.text = ""
            tvDue.text = ""

        }

    }

    private fun initializeSeekBar(){
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){

                    videoView.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })

        val tvPlayed = binding.tvPlayed
        val tvDue = binding.tvDue
        seekBar.max = mediaPlayer!!.duration
        runnable = Runnable {
            seekBar.progress = mediaPlayer!!.currentPosition

            val playedTime = mediaPlayer!!.currentPosition/1000
            tvPlayed.text = "$playedTime sec"
            val duration = mediaPlayer!!.duration/1000
            val dueTime = duration-playedTime
            tvDue.text = "$dueTime sec"

            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }

}