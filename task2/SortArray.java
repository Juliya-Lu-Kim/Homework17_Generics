package com.juliya_lu_kim.homework17Generics.task2;

/*
Задание 3
Реализуйте шаблонный метод для сортировки массива.
 */

import java.util.Arrays;

public class SortArray {

    // шаблонный метод сортировки массива
    public <T> void sortingArray(T[] array){
        Arrays.sort(array);
        System.out.println();
        System.out.println("Массив отсортирован:" + Arrays.toString(array));
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();

        Integer [] integers = new Integer[] {22, 12, 56, 99, 211, 45, 27, 70};
        Double [] doubles = new Double[] {45.4, 26.3, 12.2, 99.9, 178.12, 77.3};
        String [] strings = new String[]{"Wind", "Sky", "Black", "sweet", "free", "Happy", "new"};

        sortArray.sortingArray(integers);
        System.out.println();
        sortArray.sortingArray(doubles);
        System.out.println();
        sortArray.sortingArray(strings);
    }
}

