package com.ramil.http

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ramil.http.broadcast.Broadcast
import com.ramil.http.broadcast.BroadcastNet
import com.ramil.http.service.ForegroundService
import com.ramil.http.service.Service

class MainActivity : AppCompatActivity() {

    private val localData = Application.getApplication().localData
    private val broadcast = Broadcast()
    private val broadcastNet = BroadcastNet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(broadcast, IntentFilter().apply {
            addAction(Broadcast.ACTION)
        })

        registerReceiver(broadcastNet, IntentFilter().apply {
            addAction("android.net.wifi.WIFI_STATE_CHANGED")
        })

        Service.startService(this)
        ForegroundService.startService(this)

        val h1 = gsonFromJson(JSON_STRING)
        val h2 = jacksonFromJson(JSON_STRING)
        val h3 = moshiFromJson(JSON_STRING)
        assert(h1.name == h2.name && h2.name == h3?.name)
        assert(h1.middle_name == h2.middle_name && h2.middle_name == h3?.middle_name)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast)
        unregisterReceiver(broadcastNet)

        Service.stopService(this)
        ForegroundService.stopService(this)
    }

    override fun onStart() {
        super.onStart()

        val enterCount = localData.getInt("enter", 0) + 1

        localData.addInt("enter", enterCount)

        Broadcast
            .sendMessage(
                this,
                Intent(this, Broadcast::class.java),
                "Заход в приложение №$enterCount")
    }

}