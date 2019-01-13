package ru.poletskiy.se.lesson25;

/**
 * Threads
 *
 */
public class App
{
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main( String[] args )
    {
        countArray();
        try {
            countArrayInThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void countArray() {
        float[] arr = new float[size];
        for (float element : arr) element = 1;
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения в одном потоке: " + (System.currentTimeMillis() - a) + " мс.");
    }

    private static void countArrayInThread() throws InterruptedException {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (float element : arr) element = 1;
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Runnable r1 = new MyRunnableClass(arr1);
        Runnable r2 = new MyRunnableClass(arr2);
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Время выполнения в двух потоках: " + (System.currentTimeMillis() - a) + " мс.");
    }

    static class MyRunnableClass implements Runnable {
        float[] arr = new float[h];
        public MyRunnableClass(float[] arr) {
            this.arr = arr;
        }
        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
