package com.ramil.http.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Broadcast : BroadcastReceiver() {

    companion object{
        const val ACTION = "com.ramil.http.Listen"
        private const val DATA_STRING = "string"

        fun sendMessage(context: Context, intent : Intent, message : String){
            intent.action = ACTION
            intent.putExtra(DATA_STRING, message)
            context.sendBroadcast(intent)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (it.action == ACTION){
                val data = it.getStringExtra(DATA_STRING)

                Toast.makeText(context, data, Toast.LENGTH_LONG).show()
            }
        }
    }

}