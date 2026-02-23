package com.example.intentservice

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyIntentService : IntentService("My Intent Service") {

    companion object {
        private val TAG = "ServiceExample"
    }
    override fun onHandleIntent(intent: Intent?) {
        Log.i(TAG, "Started downloading:")

        for (i in 1..5) {
            Thread.sleep(1000)
            Log.i(TAG, "Downloading ... $i sec")
        }

        Log.i(TAG, "Download finished:")
    }
}