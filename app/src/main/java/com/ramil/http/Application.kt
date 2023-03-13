package com.ramil.http

import android.app.Application
import android.content.IntentFilter
import com.ramil.http.broadcast.Broadcast
import com.ramil.http.broadcast.BroadcastNet
import com.ramil.http.helper.storage.LocalData

class Application : Application() {

    val localData by lazy {
        LocalData(this)
    }

    companion object{
        private var application : com.ramil.http.Application? = null

        fun getApplication() = application ?: throw Exception()
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}