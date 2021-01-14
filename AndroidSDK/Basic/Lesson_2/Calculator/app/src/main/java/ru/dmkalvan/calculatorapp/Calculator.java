package ru.dmkalvan.calculatorapp;

public class Calculator {
    private static Calculator instance = null;
    private float y;
    private float x;


    private Calculator() {
    }

    public static Calculator getInstance() {
        Calculator result = instance;
        if (instance != null) {
            return result;
        }
        synchronized (Calculator.class) {
            if (instance == null) {
                instance = new Calculator();
            }
            return instance;
        }
    }

    public float add() {
        return x + y;
    }

    public float subtract() {
        return x - y;
    }

    public float multiply() {
        return x * y;
    }

    public float divide() {
        return x / y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

}
