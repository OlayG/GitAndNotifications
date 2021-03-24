package com.example.gitandnotifications.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.gitandnotifications.R

object NotificationHelper {

    private const val NOTIFICATION_ID = 43110
    private const val CHANNEL_ID = "Channel Id"
    private const val CHANNEL_NAME = "Channel Name"

    fun sendNotification(
        context: Context,
        title: String = "textTitle",
        text: String = "textContent",
        color: Int = Color.MAGENTA,
        importance: Int = NotificationCompat.PRIORITY_DEFAULT
    ) {
        val coloredTitle = SpannableString(title).apply {
            setSpan(
                ForegroundColorSpan(Color.MAGENTA),
                0,
                title.count(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_small_icon)
            .setColor(color)
            .setContentTitle(coloredTitle)
            .setContentText(text)
            .setPriority(importance)

        getManager(context).notify(NOTIFICATION_ID, builder.build())
    }

    private fun getManager(context: Context) =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @RequiresApi(Build.VERSION_CODES.O)
    fun createChannel(context: Context) = NotificationChannel(
        CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
    ).apply { getManager(context).createNotificationChannel(this) }

}