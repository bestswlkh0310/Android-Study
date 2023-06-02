package com.example.mycustomdialogpractice

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MyCustomDialog(context: Context,
                     myCustomDialogInterface: MyCustomDialogInterface)
                    : Dialog(context), View.OnClickListener {
    val TAG: String = "로그"

    private var myCustomDialogInterface: MyCustomDialogInterface? = null
    init { this.myCustomDialogInterface = myCustomDialogInterface }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)

        val yes: Button = findViewById(R.id.yes)
        val no: Button = findViewById(R.id.no)

        // 배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        yes.setOnClickListener(this)
        no.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "MyCustomDialog - onClick() called")
        when (v?.id) {
            R.id.yes -> {
                this.myCustomDialogInterface?.onYes()
            }
            R.id.no -> {
                this.myCustomDialogInterface?.onNo()
            }
        }
    }
}