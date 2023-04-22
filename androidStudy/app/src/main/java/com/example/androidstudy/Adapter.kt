package com.example.androidstudy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.databinding.ItemListBinding

class Adapter(val items: List<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ViewHolder(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ViewHolder).binding
    }
}

class ViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root)