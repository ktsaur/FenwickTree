package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = (int) ((Math.random() * 100) + 1);
        }
        System.out.println(Arrays.toString(array));

        System.out.println("Добавление элементов");
        long startTime = System.currentTimeMillis();
        FenwickTree ft = new FenwickTree(array.length);
        System.out.println("Количество операций до: " + ft.iterations);
        for (int i = 0; i < array.length; i++) {
            ft.add(i, array[i]);
        }
        System.out.println("Количество операций после: " + ft.iterations);

        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime + " мс");

        System.out.println("Нахождение элементов в структуре");
        System.out.println("Количество операций до: " + ft.iterations);
        for (int i = 0; i < 100; i++) {
            int n = (int)(Math.random() * 10000) + 1;
            ft.sum(n);
        }
        System.out.println("Количество операций после: " + ft.iterations);
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - endTime1 + " мс");

        System.out.println("Удаление элементов");
        System.out.println("Количество операций до: " + ft.iterations);
        for (int i = 0; i < 1000; i++) {
            int n = (int)(Math.random() * 10000) + 1;
            ft.delete(n);
        }
        System.out.println("Количество операций после: " + ft.iterations);
        long endTime3 = System.currentTimeMillis();
        System.out.println(endTime3 - endTime2 + " мс");
    }
}