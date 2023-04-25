package com.example.viewpagerpractice.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewpagerpractice.util.Constant.TAG

class AViewModel: ViewModel() {
    val count = MutableLiveData(1)

    fun add() {
        Log.d(TAG, "aViewModel - addCount() called")
        count.value = count.value!! + 1
    }
}