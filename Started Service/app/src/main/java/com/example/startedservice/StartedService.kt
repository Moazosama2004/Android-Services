package com.example.startedservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class StartedService : Service() {

    companion object {
        private const val TAG = "logger:"
    }

    private var thread : Thread? = null

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG , "onCreate()")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG , "onStartCommand() -> begins")
        thread = thread {
           try {
               while (!Thread.currentThread().isInterrupted) {
                   Thread.sleep(1000)
                   Log.d(TAG , "onStartCommand: Service running ....")
               }
               Log.d(TAG , "onStartCommand: Service finished!")
           }catch (e : InterruptedException) {
               Log.d(TAG, "onStartCommand: Thread Interrupted!")
           }
        }

        return super.onStartCommand(intent, flags, startId)
    }


    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG , "onDestroy()")
        thread?.interrupt()
    }
}