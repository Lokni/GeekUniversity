package ru.dmkalvan.weatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.any_button)
        button.setOnClickListener {
            changeText()
        }
    }

    private fun changeText() {
        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = getString(R.string.changed_text)

    }
}