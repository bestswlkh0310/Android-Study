package com.example.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.viewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        viewModel.count.observe(this) {
            binding.tv.text = "count : $it"
        }
        binding.btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btn -> viewModel.addCount()
        }
    }
}