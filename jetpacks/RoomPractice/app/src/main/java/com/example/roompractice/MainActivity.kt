package com.example.roompractice

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

@SuppressLint("StaticFieldLeak")
class MainActivity : AppCompatActivity() {
    private lateinit var db: UserDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = UserDatabase.getInstace(this)!!

        val insertTask = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg params: Unit?) {
                db.userDAO().setInsertUser(User(
                    null,
                    "asd",
                    "asd",
                    "asd",
                ))
            }
        }
        insertTask.execute()
    }
}