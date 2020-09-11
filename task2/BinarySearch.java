package com.juliya_lu_kim.homework17Generics.task2;

/*Задание 4
Реализуйте шаблонный метод
для двоичного поиска в массиве.
 */

import java.util.Arrays;

public class BinarySearch {

    // шаблонный метод для двоичного поиска в массиве
    public <T> void binarySearch(T[] array, T variableSearch) {
        int result = 0;
        Arrays.sort(array);
        System.out.println();
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
        System.out.println();
        for (T value: array) {
            if (variableSearch.equals(value)){
                result = 1;
            }
        }
        if (result == 1){
            System.out.println("Заданная переменная: " + variableSearch + " расположена в массиве под индексом "
                    + Arrays.binarySearch(array, variableSearch));
        } else{
            System.out.println("Заданной переменной в массиве не существует");
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        Integer [] integers = new Integer[]{3, 7, 21, 56, 73, 90, 25, 31, 17, 21, 54, 56};
        Double [] doubles = new Double[]{ 2.3, 12.5, 5.5, 21.3, 2.3, 67.7};
        String [] strings = new String[] {"Ever", "never", "like", "Nice", "bee", "too"};

        binarySearch.binarySearch(integers, 21);
        binarySearch.binarySearch(integers,55);
        System.out.println();

        binarySearch.binarySearch(doubles, 5.5);
        binarySearch.binarySearch(doubles, 3.2);
        System.out.println();

        binarySearch.binarySearch(strings, "Ever");
        binarySearch.binarySearch(strings, "Elle");
        System.out.println();
    }

}

