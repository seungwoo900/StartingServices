package edu.temple.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val COUNTDOWN_KEY = "countdown"
class TimerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var countdown = intent?.getIntExtra(COUNTDOWN_KEY, 0) ?: 0
        CoroutineScope(Dispatchers.Main).launch {
            while(countdown >= 0) {
                Log.d("countdown", "$countdown")
                delay(1000)
                countdown--
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
}