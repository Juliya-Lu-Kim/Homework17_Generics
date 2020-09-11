package com.juliya_lu_kim.homework17Generics.task1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class GenericArray<T extends Comparable<T>> {

    // Объявление типизированного массива
    T[] array;
    static Scanner scanner = new Scanner(System.in);

    // конструктор класса
    public GenericArray() {
    }

    //конструктор с параметрами
    public GenericArray(T[] array) {
        this.array = array;
    }

    // геттеры и сеттеры
    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    // методы класса для работы с массивом

    // заполнение массива с клавиатуры
    public T[] fillArrayWithKeyboard(Scanner in, Class<T> tClass) {
        System.out.println("Введите длину массива: ");
        int sizeArray = choiceLengthArray();
        T[] array = (T[]) java.lang.reflect.Array.newInstance(tClass, sizeArray);
        for (int i = 0; i < array.length; i++) {
            Object element = null;
            if (tClass == Integer.class) {
                element = scanner.nextInt();
            } else if (tClass == Double.class) {
                element = scanner.nextDouble();
            } else if (tClass == String.class) {
                element = scanner.nextLine();
            }

            array[i] = tClass.cast(element);
        }
        return array;
    }

    // заполнение массива случайными числами
    public T[] randomFillArray(Class<T> clazz) {
        Random random = new Random();
        System.out.println("Введите длину массива: ");
        int sizeArray = choiceLengthArray();
        T[] array = (T[]) Array.newInstance(clazz, sizeArray);
        for (int i = 0; i < array.length; i++) {
            java.lang.constant.Constable element = null;
            if (clazz == Integer.class) {
                element = random.nextInt(10);
            } else if (clazz == Double.class) {
                element = random.nextDouble();
            } else if (clazz == String.class) {
                Random random1 = new Random();
                String[] word = new String[]{"Z", "W", "R", "Q", "L", "M", "T", "I", "C", "G", "X", "E", "B", "T", "A", "E", "D", "Y", "N", "P"};
                element = word[random1.nextInt(word.length)];
            }
            array[i] = clazz.cast(element);
        }
        return array;
    }

    // поиск максимального значения
    public void maxElementArray(T[] array) {
        T max = array[0];
        for (T value : array) {
            if (max.compareTo(value) < 0) {
                max = value;
            }
        }
        System.out.println("Максимальное значение элемента массива равно: " + max);
    }

    // поиск минимального значения
    public void minElementArray(T[] array) {
        T min = array[0];
        for (T value : array) {
            if (min.compareTo(value) > 0) {
                min = value;
            }
        }
        System.out.println("Минимальное значение элемента массива равно: " + min);
    }

    // подсчет среднеарифметического значения
    public Double averageElementArray(T[] array, Class<T> tClass) {
        Double average = 0.0;
        if (tClass == Integer.class) {
            for (T value : array) {
                average += (Integer) value;
            }
            average = average / array.length;
        }
        if (tClass == Double.class) {
            for (T value : array) {
                average += (Double) value;
            }
            average = average / array.length;
        }
        if (tClass == String.class) {
            System.out.println("Заданный массив типа String. Среднее арифметическое значение вычислить невозможно");
        }

        return average;
    }

    // сортировка массива по возрастанию
    public <T> void sortAscending(T[] array) {
        Arrays.sort(array);
        System.out.println("Массив отсортирован по возрастанию: " + Arrays.toString(array));
    }

    // сортировка массива по убыванию
    public <T> void sortDescending(T[] array) {
        Arrays.sort(array);
        T element;
        for (int i = 0; i < array.length / 2; i++) {
            element = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = element;
        }
        System.out.println("Массив отсортирован по убыванию: " + Arrays.toString(array));
    }

    // поиск значения в массиве (бинарный)
    public void binarySearch(T[] array, T search) {
        int amount = 0;
        int index = 0;
        Arrays.sort(array);
        for (T value : array) {
            if (search.equals(value)) {
                index = 1;
                amount += 1;
            }
        }

        if (index == 1) {
            System.out.println("Индекс искомого элемента: " + search + "Результат: " + Arrays.binarySearch(array, search));
            System.out.println("Количество совпадений: " + amount);
        } else {
            System.out.println("Заданное значение: " + search + "в массиве отсутствует");
        }
    }

    // замена значения в массиве на новое значение
    public <T> T[] changeElementArray(T[] array, int index, Class<T> tClass) {
        System.out.println("Введите значение элемента, который необходимо заменить: ");
        Object element = null;
        if (tClass == Integer.class && scanner.hasNextInt()) {
            element = scanner.nextInt();
            array[index] = (T) element;
        }

        if (tClass == Double.class && scanner.hasNextDouble()) {
            element = scanner.nextDouble();
            array[index] = (T) element;
        }

        if (tClass == String.class && scanner.hasNextLine()) {
            element = scanner.nextLine();
            array[index] = (T) element;
        }
        return array;
    }

    //==================================== Новый класс ============================================
    // выбор типа элементов в массиве
    public Class<T> choiceTypeElement() {
        Class clazz = Object.class;
        System.out.println("Выберите тип массива: ");
        System.out.println("1 - String - массив строк");
        System.out.println("2 - Integer - массив целых чисел");
        System.out.println("3 - Double - массив дробных чисел");

        while (true) {
            if (scanner.hasNextLine()) {
                int i = scanner.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Тип данных в массиве String");
                        clazz = String.class;
                        break;

                    case 2:
                        System.out.println("Тип данных в массиве Integer ");
                        clazz = Integer.class;
                        break;

                    case 3:
                        System.out.println("Тип данных в массиве Double");
                        clazz = Double.class;
                        break;

                    default:
                        System.out.println("Вы ввели неверный параметр. Повторите ввод");
                        this.choiceTypeElement();
                        break;
                }
                break;
            } else {
                System.out.println("Вы ввели неверный параметр. Повторите ввод");
                this.choiceTypeElement();
            }
        }
        return clazz;
    }

    // метод для ввода значения длины массива
    public int choiceLengthArray() {
        int lengthArray = 0;
        while (true) {
            if (scanner.hasNextLine()) {
                lengthArray = scanner.nextInt();
                if (lengthArray > 0) {
                    System.out.println("Длина массива равна: " + lengthArray);
                    break;
                } else {
                    System.out.println("Вы ввели не целое число. Введите, пожалуйста, целое число");
                }
            } else {
                System.out.println("Вы ввели не целое число. Введите, пожалуйста, целое число");
            }
        }
        return lengthArray;
    }

    //метод для выбора способа заполнения массива
    public int choiceMethodFillArray() {
        System.out.println("Выберите способ заполнения массива: ");
        System.out.println("1 - Заполнить массив рандомными значениями");
        System.out.println("2 - Заполнить массив с клавиатуры");

        int userChoice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice == 1 || userChoice == 2) {
                    switch (userChoice) {
                        case 1:
                            System.out.println("Заполнить массив рандомными значениями");
                            break;
                        case 2:
                            System.out.println("Заполнить массив с клавиатуры");
                            break;
                    }
                    break;
                } else {
                    System.out.println("Неправильны ввод. Введите один из предложенных вариантов.");
                }
                break;
            } else {
                System.out.println("Неправильны ввод. Введите один из предложенных вариантов.");
            }
        }
        return userChoice;
    }


    // метод, отвечающий за выбор операции над массивом
    public int menuArrayOperation() {
        System.out.println();
        System.out.println("Выберите операцию для работы с массивом: ");
        System.out.println("1 - Выбрать минимальный элемент массива");
        System.out.println("2 - Выбрать максимальный элемент массива ");
        System.out.println("3 - Вывести среднеарифметическое значение всех элементов массива ");
        System.out.println("4 - Отсортировать элементы массива по возрастанию");
        System.out.println("5 - Отсортировать элементы массива по убыванию");
        System.out.println("6 - Бинарный поиск");
        System.out.println("7 - Заменить элемент массива на новый");
        System.out.println("8 - Завершение работы с массивом");
        System.out.println();

        int i = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                if (i >= 1 && i <= 8) {
                    break;
                } else {
                    System.out.println("Данного пункта меню не существует. Повторите ввод");
                    menuArrayOperation();
                }
            }
        }
        return i;
    }

    public <T> T choiceElement(Class<T> tClass) {
        java.lang.constant.Constable element = null;
        while (true) {
            if (tClass == Integer.class) {
                if (scanner.hasNextInt()) {
                    element = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Тип введенной переменной не соответствует типу массива: " + tClass.getName());
                }
            }

            if (tClass == Double.class) {
                if (scanner.hasNextDouble()) {
                    element = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Тип введенной переменной не соответствует типу массива: " + tClass.getName());
                }
            }

            if (tClass == String.class) {
                element = scanner.nextLine();
                break;
            } else {
                System.out.println("Тип введенной переменной не соответствует типу массива: " + tClass.getName());
            }
        }
        return tClass.cast(element);
    }

    //запускающий метод
    public void run() {
        Class<T> clazz = choiceTypeElement();
        int i = 0;
        while (true) {
            i = choiceMethodFillArray();
            if (i == 1 || i == 2) {
                break;
            }
        }

        GenericArray<T> userArray = new GenericArray<T>(array);
        switch (i) {
            case 1:
                array = randomFillArray(clazz);
                System.out.println("Массив заполненный случайными значениями: " + Arrays.toString(array));
                break;
            case 2:
                array = (fillArrayWithKeyboard(scanner, clazz));
                System.out.println();
                System.out.println("Вы заполнили массив следующими значениями: " + Arrays.toString(array));
                break;
        }
        while (true) {
            int menuItem = menuArrayOperation();

            switch (menuItem) {
                case 1:
                    System.out.println("Нахождение минимального элемента массива: ");
                    minElementArray(array);
                    break;

                case 2:
                    System.out.println("Нахождение максимального элемента массива:");
                    maxElementArray(array);
                    break;

                case 3:
                    System.out.println("Среднеарифметическое значение всех элементов массива: " +
                            userArray.averageElementArray(array, clazz));
                    break;

                case 4:
                    System.out.println("Сортировка элементов массива по возрастанию: ");
                    userArray.sortAscending(array);
                    break;

                case 5:
                    System.out.println("Сортировка элементов массива по убыванию: ");
                    userArray.sortDescending(array);
                    break;

                case 6:
                    System.out.println("Бинарный поиск: ");
                    System.out.println("Введите значение переменной: ");
                    T a = choiceElement(clazz);
                    userArray.binarySearch(array, a);
                    break;

                case 7:
                    System.out.println("Заменить элемент по индексу в массиве");
                    System.out.println("Введите индекс элемента массива, который необходимо заменить: ");
                    while (true) {
                        if (scanner.hasNextInt()) {
                            int index = scanner.nextInt();
                            if (index < array.length) {
                                userArray.changeElementArray(array, index, clazz);
                                System.out.println("Измененный массив: " + Arrays.toString(array));
                                break;
                            } else {
                                System.out.println("Вы ввели несуществующий индекс массива. Повторите ввод");
                            }
                        } else {
                            System.out.println("Вы ввели несуществующий индекс массива. Повторите ввод");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Программа завершена");
                    break;

                default:
                    System.out.println("Повторите ввод");
                    break;
            }
            if (menuItem == 8) {
                break;
            }
        }
    }
}


