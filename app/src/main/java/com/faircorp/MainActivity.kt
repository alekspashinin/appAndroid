package com.faircorp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(">>>>>> TEST1 <<<<<<<")
        setContentView(R.layout.activity_main)
    }
    /** Called when the user taps the button */
    fun openWindow(view: View) {
        println(">>>>>> TEST2 <<<<<<<")
        val windowName = findViewById<EditText>(R.id.txt_window_name_first).text.toString()
        // Do something in response to button
        val intent = Intent(this, WindowActivity::class.java).apply {
            putExtra(WINDOW_NAME_PARAM, windowName)
        }
        println(">>>>>> TEST3 <<<<<<<")
        startActivity(intent)
    }
}