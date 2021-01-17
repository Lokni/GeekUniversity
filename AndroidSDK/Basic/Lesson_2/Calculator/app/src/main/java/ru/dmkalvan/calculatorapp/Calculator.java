package ru.dmkalvan.calculatorapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    private static Calculator instance = null;
    private float y;
    private float x;

    private Calculator() {
    }

    protected Calculator(Parcel in) {
        y = in.readFloat();
        x = in.readFloat();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(y);
        dest.writeFloat(x);
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

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
