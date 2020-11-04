package com.projectlite.android

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.leancloud.AVObject
import cn.leancloud.chatkit.LCChatKit
import cn.leancloud.chatkit.activity.LCIMConversationActivity
import cn.leancloud.chatkit.utils.LCIMConstants
import cn.leancloud.im.v2.AVIMClient
import cn.leancloud.im.v2.AVIMException
import cn.leancloud.im.v2.callback.AVIMClientCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            thread {
                val testObject = AVObject("TestObject")
                testObject.put("words", "Hello world!")
                testObject.saveInBackground().blockingSubscribe()
                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
            }
        }

        button3.setOnClickListener {

            LCChatKit.getInstance()
                .open("Tom", object : AVIMClientCallback() {
                    override fun done(avimClient: AVIMClient, e: AVIMException) {
                        finish()
                        val intent =
                            Intent(this@MainActivity, LCIMConversationActivity::class.java)
                        intent.putExtra(LCIMConstants.PEER_ID, "Jerry")
                        startActivity(intent)
                    }
                })

        }

    }

}