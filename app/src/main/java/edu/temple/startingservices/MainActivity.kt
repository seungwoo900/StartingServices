package edu.temple.startingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity() {
    lateinit var timerEditText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerEditText = findViewById(R.id.editTextText)
        button = findViewById(R.id.button)

        button.setOnClickListener {

            startService(Intent(this, TimerService::class.java).apply {
                putExtra(COUNTDOWN_KEY, timerEditText.text.toString().toInt())
            })
        }

    }
}