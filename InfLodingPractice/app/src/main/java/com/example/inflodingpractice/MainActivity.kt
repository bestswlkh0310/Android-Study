package com.example.inflodingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inflodingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataList: List<Person> = arrayListOf(
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
            Person("nam", "12"),
        )

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = Adapter(dataList, this)

        binding.rv.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.rv.canScrollVertically(1)) {
                    Log.d(TAG, "MainActivity - onScrolled() called")
                }
            }
        })
    }
}