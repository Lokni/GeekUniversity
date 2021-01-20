package ru.dmkalvan.calculatorapp;
/**
 * 1. Создайте активити с настройками, где включите выбор темы приложения.
 * <p>
 * 2. Доделайте приложение «Калькулятор». Это последний урок с созданием приложения
 * «Калькулятор».
 * <p>
 * 3. * Сделайте интент-фильтр для запуска калькулятора извне, а также напишите тестовое
 * приложение, запускающее приложение-калькулятор.
 * <p>
 * (*) Задача для дополнительного обучения.
 *
 * @author Dmitri Kalvan
 * @20.01.21
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY = "calculator";

    Button btn0, btn1, btn2, btn3, btn4, btn5,
            btn6, btn7, btn8, btn9,
            btnPlus, btnMinus, btnMultiply, btnDivide,
            btnEqual, btnPercent, btnComma, btnABS, btnCancel;

    Calculator calculator = Calculator.getInstance();
    private TextView numberField;
    private boolean operationAdd,
            operationSubtract,
            operationMultiply,
            operationDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberField = findViewById(R.id.number_field);
        initButton();
    }

    @SuppressLint({"NonConstantResourceId", "ResourceAsColor"})
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
                calculator.setX(Float.parseFloat(numberField.getText().toString()));
                operationAdd = true;
                numberField.setText(R.string.default_number);
                break;
            case R.id.minus_button:
                calculator.setX(Float.parseFloat(numberField.getText().toString()));
                operationSubtract = true;
                numberField.setText(R.string.default_number);
                break;
            case R.id.multiply_button:
                calculator.setX(Float.parseFloat(numberField.getText().toString()));
                operationMultiply = true;
                numberField.setText(R.string.default_number);
                break;
            case R.id.divide_button:
                calculator.setX(Float.parseFloat(numberField.getText().toString()));
                operationDivide = true;
                numberField.setText(R.string.default_number);
                break;
            case R.id.equal_button:
                calculator.setY(Integer.parseInt(numberField.getText().toString()));
                if (operationAdd) {
                    numberField.setText(String.format(Locale.getDefault(), "%s", calculator.add()));
                    operationAdd = false;
                }
                if (operationSubtract) {
                    numberField.setText(String.format(Locale.getDefault(), "%s", calculator.subtract()));
                    operationSubtract = false;
                }
                if (operationMultiply) {
                    numberField.setText(String.format(Locale.getDefault(), "%s", calculator.multiply()));
                    operationMultiply = false;
                }
                if (operationDivide) {
                    numberField.setText(String.format(Locale.getDefault(), "%s", calculator.divide()));
                    operationDivide = false;
                }
                break;
            case R.id.percent_button:
                Float percent = Float.parseFloat(numberField.getText().toString()) / 100;
                numberField.setText(String.format("%s", percent));
                break;
            case R.id.abs_button:
                if (numberField.getText().toString() != null) {
                    Float ch = Float.parseFloat(numberField.getText().toString()) * -1;
                    numberField.setText(String.format("%s", ch));
                }
                break;
            case R.id.cancel_button:
                numberField.setText("");
                break;
            case R.id.comma_button:
                numberField.setText(String.format("%s.", numberField.getText().toString()));
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void setNumberField(int x) {
        if (numberField.getText().toString().length() == 1 &&
                numberField.getText().toString().equalsIgnoreCase("0")) {
            numberField.setText(String.valueOf(x));
        } else {
            numberField.setText(numberField.getText() + String.valueOf(x));
        }
    }

    private void initButton() {
        btn0 = findViewById(R.id.n_0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.n_1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.n_2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.n_3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.n_4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.n_5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.n_6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.n_7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.n_8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.n_9);
        btn9.setOnClickListener(this);
        btnPlus = findViewById(R.id.plus_button);
        btnPlus.setOnClickListener(this);
        btnMinus = findViewById(R.id.minus_button);
        btnMinus.setOnClickListener(this);
        btnMultiply = findViewById(R.id.multiply_button);
        btnMultiply.setOnClickListener(this);
        btnDivide = findViewById(R.id.divide_button);
        btnDivide.setOnClickListener(this);
        btnEqual = findViewById(R.id.equal_button);
        btnEqual.setOnClickListener(this);
        btnPercent = findViewById(R.id.percent_button);
        btnPercent.setOnClickListener(this);
        btnComma = findViewById(R.id.comma_button);
        btnComma.setOnClickListener(this);
        btnABS = findViewById(R.id.abs_button);
        btnABS.setOnClickListener(this);
        btnCancel = findViewById(R.id.cancel_button);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable(KEY);
        numberField.setText(String.format("%s", calculator.getX()));
    }
}