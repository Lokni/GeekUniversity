package ru.dmkalvan.calculatorapp;
/**
 * С этого урока будем писать приложение «Калькулятор».
 * <p>
 * 1. Выберите макет для работы с калькулятором. Обоснуйте,
 * почему будете использовать именно этот тип макета.
 * <p>
 * 2. Сверстайте главный экран калькулятора.
 * На нём должны быть кнопки, обозначающие цифры и знаки действия:
 * «Плюс», «Умножить», «Разделить», «Вычесть» и т. п.
 * <p>
 * 3*. Добавьте фоновый рисунок для экрана калькулятора.
 * Следите, чтобы рисунок был для общего использования.
 * Ресурсы: PxHere, Pixabay
 *
 * @author Dmitri Kalvan
 * @date: 09.01.21
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}