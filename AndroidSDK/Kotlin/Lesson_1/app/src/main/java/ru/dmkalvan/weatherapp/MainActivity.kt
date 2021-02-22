package ru.dmkalvan.weatherapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * 1. Создать новый проект в Android Studio без поддержки Kotlin.
 * 2. Сконфигурировать Kotlin в новом проекте (лучше вручную).
 * 3. Перевести MainActivity на Kotlin.
 * 4. Добавить кнопку в разметку и повесить на неё clickListener в Activity.
 * 5. Потренироваться в создании классов и функций, описанных в уроке, и убедиться, что всё
 *    работает. К примеру, создайте тестовое приложение:
 *    a. создайте data class с двумя свойствами, выведите их на экран приложения;
 *    b. создайте Object, в Object вызывайте copy и выводите значения скопированного класса на экран;
 *    c. выводите значения из разных циклов в консоль, используя примеры из методических материалов.
 *
 * @author Dmitri Kalvan
 * @date 21.02.21
 */

class MainActivity : AppCompatActivity() {
    val TAG = "cycles"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.any_button)
        button.setOnClickListener {
            changeText()
        }

        for(i in 1..5){
            Log.i(TAG, i.toString())
        }

        for (i in 5 downTo 0){
            Log.i(TAG, i.toString())
        }


    }

    private fun changeText() {
        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = getString(R.string.changed_text)

    }
}