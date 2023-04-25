package com.example.viewpagerpractice.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.databinding.FragmentABinding
import com.example.viewpagerpractice.util.Constant.TAG
import com.example.viewpagerpractice.viewModel.AViewModel

class AFragment: Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentABinding
    private val viewModel: AViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "AFragment - onCreateView() called")
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_a,
            container,
            false)
        binding.btnAdd.setOnClickListener(this)

        with (viewModel) {
            count.observe(viewLifecycleOwner) {
                val text = "count : $it"
                binding.tvCount.text = text
            }
        }

        return binding.root
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnAdd -> {
                Log.d(TAG, "AFragment - onClick() called")
                viewModel.add()
            }
        }
    }
}