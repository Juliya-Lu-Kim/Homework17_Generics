package com.juliya_lu_kim.homework17Generics.task2;

/*
Задание 1
Напишите шаблонный метод, который возвращает
максимум из трёх переданных параметров.
 */
public class MaxElement {

    public <T extends Comparable<T>> T maxElement (T[] array){
        T max = array[0];
        for (T value: array) {
            if (max.compareTo(value) < 0){
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxElement maxElement = new MaxElement();
        Integer [] integers = new Integer[] {87, 45, 15};
        System.out.println("Максимальное значене массива целых чисел: " + maxElement.maxElement(integers));
        System.out.println();
        Double [] doubles = new Double[] {34.3, 45.1, 12.3};
        System.out.println("Максимальное значене массива дробных чисел: " + maxElement.maxElement(doubles));
        System.out.println();
        String [] strings = new String[] {"eeeee", "bb", "cccc"};
        System.out.println("Максимальное значене строкового массива: " + maxElement.maxElement(strings));
        System.out.println();
    }
}

