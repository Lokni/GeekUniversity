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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView numberField = findViewById(R.id.number_field);
    Calculator calculator = new Calculator();
    private String x;
    private String y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.n_0:
                setNumberField(0);
                break;
            case R.id.n_1:
                setNumberField(1);
                break;
            case R.id.n_2:
                setNumberField(2);
                break;
            case R.id.n_3:
                setNumberField(3);
                break;
            case R.id.n_4:
                setNumberField(4);
                break;
            case R.id.n_5:
                setNumberField(5);
                break;
            case R.id.n_6:
                setNumberField(6);
                break;
            case R.id.n_7:
                setNumberField(7);
                break;
            case R.id.n_8:
                setNumberField(8);
                break;
            case R.id.n_9:
                setNumberField(9);
                break;
            case R.id.plus_button:
               x = numberField.getText().toString();
                break;
            case R.id.minus_button:
                x = numberField.getText().toString();
                break;
            case R.id.multiply_button:
                x = numberField.getText().toString();
                break;
            case R.id.divide_button:
                x = numberField.getText().toString();
                break;
            case R.id.equal_button:
                x = numberField.getText().toString();
                break;
            case R.id.percent_button:
                x = numberField.getText().toString();
                break;
            case R.id.abs_button:
                x = numberField.getText().toString();
                break;
            case R.id.cancel_button:
                x = numberField.getText().toString();
                break;

        }
    }
    private void setNumberField(int x){
        numberField.setText(String.valueOf(x));
    }

    private void initButton(){
        Button btn0 = findViewById(R.id.n_0);
        btn0.setOnClickListener(this);
        Button btn1 = findViewById(R.id.n_1);
        btn1.setOnClickListener(this);
        Button btn2 = findViewById(R.id.n_2);
        btn2.setOnClickListener(this);
        Button btn3 = findViewById(R.id.n_3);
        btn3.setOnClickListener(this);
        Button btn4 = findViewById(R.id.n_4);
        btn4.setOnClickListener(this);
        Button btn5 = findViewById(R.id.n_5);
        btn5.setOnClickListener(this);
        Button btn6 = findViewById(R.id.n_6);
        btn6.setOnClickListener(this);
        Button btn7 = findViewById(R.id.n_7);
        btn7.setOnClickListener(this);
        Button btn8 = findViewById(R.id.n_8);
        btn8.setOnClickListener(this);
        Button btn9 = findViewById(R.id.n_9);
        btn9.setOnClickListener(this);
        Button btnPlus = findViewById(R.id.plus_button);
        btnPlus.setOnClickListener(this);
        Button btnMinus = findViewById(R.id.minus_button);
        btnMinus.setOnClickListener(this);
        Button btnMultiply = findViewById(R.id.multiply_button);
        btnMultiply.setOnClickListener(this);
        Button btnDivide = findViewById(R.id.divide_button);
        btnDivide.setOnClickListener(this);
        Button btnEqual = findViewById(R.id.equal_button);
        btnEqual.setOnClickListener(this);
        Button btnPercent = findViewById(R.id.percent_button);
        btnPercent.setOnClickListener(this);
        Button btnComma = findViewById(R.id.comma_button);
        btnComma.setOnClickListener(this);
        Button btnABS = findViewById(R.id.abs_button);
        btnABS.setOnClickListener(this);
        Button btnCancel = findViewById(R.id.cancel_button);
        btnCancel.setOnClickListener(this);
    }
}