package com.androiddev.recicleviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitList : List<Fruit>,
    private val clickListener: (Fruit)->Unit
    ) : RecyclerView.Adapter<MyViewHolder>() {

//    Cria o modo do layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

//    Altera oq está nos itens
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitList[position],clickListener)
    }

//    Cria um numero x de itens
    override fun getItemCount(): Int {
        return fruitList.size
    }
}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){

    fun bind(fruit: Fruit, clickListener: (Fruit)->Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener{
            clickListener(fruit)
        }
    }

}