package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(private val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = absoluteAdapterPosition
                val profile: Profiles = profileList[curPos]
                Toast.makeText(parent.context, "${profile.age}", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList[position].gender)
        holder.name.text = profileList[position].name
        holder.age.text = profileList[position].age.toString()
        holder.job.text = profileList[position].job
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val age = itemView.findViewById<TextView>(R.id.tv_age)
        val job = itemView.findViewById<TextView>(R.id.tv_job)
    }
}