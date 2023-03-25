package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
            Profiles(R.drawable.baseline_church_24, "어쩔", 99, "저쩔"),
        )
        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true)
        rv_profile.adapter = ProfileAdapter(profileList)
    }
}