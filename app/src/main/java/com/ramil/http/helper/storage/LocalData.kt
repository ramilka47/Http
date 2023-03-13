package com.ramil.http.helper.storage

import android.content.Context

class LocalData(context: Context) {

    companion object{
        private const val SHARED_PREFERENCES_NAME = "local"
    }

    private val preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun addInt(key : String, int : Int) = preferences.edit().putInt(key, int).apply()

    fun getInt(key: String, defValue : Int = -1) = preferences.getInt(key, defValue)

}