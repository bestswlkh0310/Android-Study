package com.example.viewmodelpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    var count = MutableLiveData(0)

    fun addCount() {
        count.value = count.value!! + 1
    }
}