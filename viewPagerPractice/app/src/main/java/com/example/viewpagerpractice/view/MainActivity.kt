package com.example.viewpagerpractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.databinding.ActivityMainBinding
import com.example.viewpagerpractice.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.flMain.adapter = Adapter(this)
        binding.flMain.orientation = ViewPager2.ORIENTATION_VERTICAL
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}