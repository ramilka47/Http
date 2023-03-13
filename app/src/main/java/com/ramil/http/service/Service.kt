package com.ramil.http.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder

class Service : Service() {

    companion object{
        fun startService(context: Context) =
            context.startService(Intent(context, Service::class.java))

        fun stopService(context: Context) =
            context.stopService(Intent(context, Service::class.java))
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}