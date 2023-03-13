package com.ramil.http.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder

class ForegroundService : Service(){

    companion object{
        fun startService(context : Context) =
            context.startForegroundService(Intent(context, ForegroundService::class.java))

        fun stopService(context: Context) =
            context.stopService(Intent(context, ForegroundService::class.java))
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}