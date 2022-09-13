package com.androiddev.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androiddev.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    +-----------------------------------------------------------------------+
//    |  Ao girar a tela do celular, por exemplo, o valor do count é resetado.|
//    |  Por isso precisamos implementar ViewModel e LiveData.                |
//    |  Não foi preciso declarar dependencias pois ja estao inclusas.
//    +-----------------------------------------------------------------------+

    private lateinit var viewModel : MainActivityViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val btnCount = binding.btnCount
        val textView = binding.textView

//        textView.text = viewModel.count.toString()
//        Linha acima comentada por conta da inserção do LiveData   

        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        btnCount.setOnClickListener{

            viewModel.updateCount()
//            textView.text = viewModel.count.toString()
//            Linha acima comentada por conta da inserção do LiveData

        }

    }
}