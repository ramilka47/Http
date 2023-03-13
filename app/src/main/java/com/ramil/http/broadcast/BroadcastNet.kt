package com.ramil.http.broadcast

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import com.ramil.http.MainActivity


class BroadcastNet : BroadcastReceiver() {

    private var available = false

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        val connMgr = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI) as NetworkInfo

        val mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE) as NetworkInfo

        if (!wifi.isConnected && !mobile.isConnected) {
            available = false
            Toast.makeText(context, "Интернет недоступен", Toast.LENGTH_SHORT).show()
        }
        if ((wifi.isConnected || mobile.isConnected) && !available){
            available = true
            Toast.makeText(context, "Интернет доступен", Toast.LENGTH_SHORT).show()
        }
    }

}