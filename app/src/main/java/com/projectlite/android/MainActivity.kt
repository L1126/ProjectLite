package com.projectlite.android

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.leancloud.AVObject
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button2.setOnClickListener {
            val testObject = AVObject("TestObject")
            testObject.put("words", "Hello world!")
            testObject.saveInBackground().blockingSubscribe()
            Toast.makeText(this,"Done!",Toast.LENGTH_SHORT).show()
        }

        button3.setOnClickListener {
            Toast.makeText(this,"OK!",Toast.LENGTH_SHORT).show()

        }

    }

}