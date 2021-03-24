package com.example.gitandnotifications.view

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gitandnotifications.databinding.ActivityMainBinding
import com.example.gitandnotifications.utils.NotificationHelper

/**
 * git status
 * git add *
 * git commit -m "commit message"
 * git push
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            btnSendNotification.setOnClickListener {
                NotificationHelper.sendNotification(this@MainActivity)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) NotificationHelper.createChannel(this)
    }
}