package com.example.inflodingpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Adapter(var datas: List<Person>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cellForRow = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datas[position]
        holder.name.text = data.name
        holder.age.text = data.age
    }
}
class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val name = v.findViewById<TextView>(R.id.name)
    val age = v.findViewById<TextView>(R.id.age)
}