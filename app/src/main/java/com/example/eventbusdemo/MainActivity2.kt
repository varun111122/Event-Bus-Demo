package com.example.eventbusdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.greenrobot.eventbus.EventBus

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var btn_back = findViewById<Button>(R.id.btn_back)
        var btn_fireEvent = findViewById<Button>(R.id.btn_fireEvent)


        btn_back.setOnClickListener {
            finish()

        }

        btn_fireEvent.setOnClickListener {
            var eventClass = EventClass("varun", "24")

            EventBus.getDefault().post(eventClass)
        }


    }
}