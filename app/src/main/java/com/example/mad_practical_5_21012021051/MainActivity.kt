package com.example.mad_practical_5_21012021051

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonBrowse: Button = findViewById(R.id.btnBrowse)
        val editUrl : EditText = findViewById(R.id.EditTextUrl)

        buttonBrowse.setOnClickListener()
        {
            onBrowse(editUrl.text.toString())
        }

        val buttonCall: Button = findViewById(R.id.btnCall)
        val callNumber : EditText = findViewById(R.id.EditTextNumber )

        buttonCall.setOnClickListener()
        {
            onCall(callNumber.text.toString())
        }

        val buttonCallLog: Button = findViewById(R.id.btnCallLog)

        buttonCallLog.setOnClickListener()
        {
            onCallLog()
        }

        val buttonGallery: Button = findViewById(R.id.btnGallery)

        buttonGallery.setOnClickListener()
        {
            onGallery()
        }

        val buttonCamera: Button = findViewById(R.id.btnCamera)

        buttonCamera.setOnClickListener()
        {
            onCamera()
        }

        val buttonAlarm: Button = findViewById(R.id.btnAlarm)

        buttonAlarm.setOnClickListener()
        {
            onAlarm()
        }

    }
    fun onBrowse(url: String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also{startActivity(it) }
    }
    fun onCall(number:String)
    {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }
    }
    fun onCallLog()
    {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun onGallery()
    {
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun onCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun onAlarm()
    {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }

}