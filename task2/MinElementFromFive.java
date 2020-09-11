package com.juliya_lu_kim.homework17Generics.task2;

/*
Задание 2
Напишите шаблонный метод, который возвращает
минимум из пяти переданных параметров.
 */
public class MinElementFromFive {

    public <T extends Comparable<T>> T minElement (T[] array){
        T min = array[0];
        for (T value: array) {
            if (min.compareTo(value) > 0){
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinElementFromFive minElementFromFive = new MinElementFromFive();

        Integer [] integers = new Integer[] {87, 45, 15, 21, 93};
        System.out.println("Минимальное значене массива целых чисел: " + minElementFromFive.minElement(integers));
        System.out.println();
        Double [] doubles = new Double[] {34.3, 45.1, 12.3, 78.6, 21.2};
        System.out.println("Минимальное значене массива дробных чисел: " + minElementFromFive.minElement(doubles));
        System.out.println();
        String [] strings = new String[] {"eeeee", "bb", "cccc", "www", "llll"};
        System.out.println("Минимальное значене строкового массива: " + minElementFromFive.minElement(strings));
        System.out.println();
    }

}

