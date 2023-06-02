package com.example.apipractice.moveRv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice.R

class MovieAdapter(private val movieList: Array<Movies?>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val rank = itemView.findViewById<TextView>(R.id.tv_rank)
        val openDay = itemView.findViewById<TextView>(R.id.tv_openDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = absoluteAdapterPosition
                val movie: Movies? = movieList[curPos]
                Toast.makeText(parent.context, "${movie?.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = movieList[position]?.name
        holder.rank.text = movieList[position]?.rank.toString()
        holder.openDay.text = "개봉일 : " + movieList[position]?.openDay
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}