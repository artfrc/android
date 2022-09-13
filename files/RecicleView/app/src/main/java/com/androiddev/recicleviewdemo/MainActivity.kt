package com.androiddev.recicleviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddev.recicleviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    Foi criado uma data class para passar os parametros das frutas

    private val fruitList = listOf<Fruit>(
        Fruit("Mango", "Tom"),
        Fruit("Apple", "Frank"),
        Fruit("Banana", "Arthur"),
        Fruit("Guava", "Joe"),
        Fruit("Limon", "Ana"),
        Fruit("Pear", "Joe"),
        Fruit("Orange", "Ana")
    )

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        val recyclerView = binding.myRecyclerView
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(
            fruitList,
        ) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit){

        Toast.makeText(
            this@MainActivity,"Selected Suppler is: ${fruit.supplier}", Toast.LENGTH_SHORT
        ).show()

    }
}