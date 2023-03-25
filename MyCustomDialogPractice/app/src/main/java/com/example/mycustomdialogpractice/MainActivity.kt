package com.example.mycustomdialogpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyCustomDialogInterface {
    private val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")
    }

        fun onDialogClicked (v: View) {
            Log.d(TAG, "MainActivity - onDialogClicked() called")

            val myCustomDialog = MyCustomDialog(this, this)
            myCustomDialog.show()
        }

    override fun onYes() {
        Log.d(TAG, "MainActivity - onYes() called")
        Toast.makeText(this, "예스", Toast.LENGTH_SHORT).show()
    }

    override fun onNo() {
        Log.d(TAG, "MainActivity - onNo() called")
        Toast.makeText(this, "노", Toast.LENGTH_SHORT).show()
    }
}