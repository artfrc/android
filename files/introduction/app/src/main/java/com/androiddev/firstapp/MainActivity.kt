package com.androiddev.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.TextView
import android.widget.Toast
import com.androiddev.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnConfirm.setOnClickListener{

            if(binding.tvType.text.toString() != ""){
                binding.tvPrintType.text = binding.tvType.text.toString()
                binding.btnViewOffers.visibility = VISIBLE
                binding.btnLogout.visibility = VISIBLE
                binding.tvType.visibility = INVISIBLE
                binding.btnConfirm.visibility = INVISIBLE
            }else{
                Toast.makeText(this, "empty field", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnLogout.setOnClickListener{
            binding.tvPrintType.text = ""
            binding.tvType.text.clear()
            binding.btnViewOffers.visibility = INVISIBLE
            binding.btnLogout.visibility = INVISIBLE
            binding.tvType.visibility = VISIBLE
            binding.btnConfirm.visibility = VISIBLE
        }

        binding.btnViewOffers.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            val name = binding.tvType.text.toString()
            intent.putExtra("TYPE_USER", name)
            startActivity(intent)
            //finish()
        }

    }

}