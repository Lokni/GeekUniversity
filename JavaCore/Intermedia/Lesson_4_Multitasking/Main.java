package Lesson_5_Multitasking;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static final int PETA = SIZE / 5;

    // Calculating method.
    private static void operation(float[] array, int quotient) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (i + quotient) / 5.0) * Math.cos(0.2f + (i + quotient)/ 5.0)
                    * Math.cos(0.4f + (i + quotient)/ 2.0));
//            System.out.println(array[i]);
        }
        System.out.println("Array.length = " + array.length);
        // That was output for checking last result of calculating.
//        System.out.println("Last calculating result in array " + array[array.length-1]);
    }

    private static void doubleFlow(float[] arr) {
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        // Separate array for two parts.
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        // Create first thread with first half array.
        Thread t1 = new Thread(() -> operation(arr1, 0));
        // Create second thread with second half array.
        Thread t2 = new Thread(() -> operation(arr2, HALF));

        // Start threads.
        t1.start();
        t2.start();

        // Join array back together.
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void petaFlow(float[] arr) {
        float[] arr1 = new float[PETA];
        float[] arr2 = new float[PETA];
        float[] arr3 = new float[PETA];
        float[] arr4 = new float[PETA];
        float[] arr5 = new float[PETA];
        // Separate array for two parts.
        System.arraycopy(arr, 0, arr1, 0, PETA);
        System.arraycopy(arr, PETA, arr2, 0, PETA);
        System.arraycopy(arr, PETA, arr3, 0, PETA);
        System.arraycopy(arr, PETA, arr4, 0, PETA);
        System.arraycopy(arr, PETA, arr5, 0, PETA);


        // Create first thread with first half array.
        Thread t1 = new Thread(() -> operation(arr1, 0));
        // Create second thread with second half array.
        Thread t2 = new Thread(() -> operation(arr2, PETA));
        Thread t3 = new Thread(() -> operation(arr2, PETA* 2));
        Thread t4 = new Thread(() -> operation(arr2, PETA * 3));
        Thread t5 = new Thread(() -> operation(arr2, PETA * 4));

        // Start threads.
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Join array back together.
        System.arraycopy(arr1, 0, arr, 0, PETA);
        System.arraycopy(arr2, 0, arr, PETA, PETA);
        System.arraycopy(arr3, 0, arr, PETA, PETA);
        System.arraycopy(arr4, 0, arr, PETA, PETA);
        System.arraycopy(arr5, 0, arr, PETA, PETA);

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        // Filling array with 1.
        Arrays.fill(arr, 1);

        // Double flow method start.
        long flowStart = System.currentTimeMillis();
        doubleFlow(arr);
        System.out.println("Double flow result: " + (System.currentTimeMillis() - flowStart));

        // Peta start.
        long petaFlowStart = System.currentTimeMillis();
        petaFlow(arr);
        System.out.println("Peta flow result: " + (System.currentTimeMillis() - petaFlowStart));

        // Output with simple one thread operation.
        long start = System.currentTimeMillis();
        operation(arr, 0);
        System.out.println("Mono flow result: " + (System.currentTimeMillis() - start));

    }
}
