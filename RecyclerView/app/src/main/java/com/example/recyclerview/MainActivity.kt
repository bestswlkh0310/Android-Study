package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv_profile: RecyclerView = findViewById(R.id.rv_profile)

        val profileList = arrayListOf(
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어엄", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어엄", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
            Profiles(R.drawable.baseline_church_24, "어쩔", 99111, "저쩔"),
        )
//        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        rv_profile.layoutManager = GridLayoutManager(this, 2)
//        rv_profile.layoutManager = GridLayoutManager(this, 10, RecyclerView.HORIZONTAL, true)
        rv_profile.layoutManager = StaggeredGridLayoutManager(10, RecyclerView.HORIZONTAL)
        rv_profile.setHasFixedSize(true)
        rv_profile.adapter = ProfileAdapter(profileList)
    }
}