package com.example.eventbusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*

class MainActivity() : AppCompatActivity() {
    var txt: TextView? = null
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EventBus.getDefault().register(this)

        var btn = findViewById<Button>(R.id.btn_click)
        txt = findViewById(R.id.txt_count)

        btn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getEventResult(eventClass: EventClass) {
        txt?.setText("${eventClass.name}")

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }


}