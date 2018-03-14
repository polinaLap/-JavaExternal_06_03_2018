package com.company;
import java.util.Random;
public class Main {
    private static Random random = new Random();
    private static int maxNumber = 100;


    public static void main(String[] args) {
        System.out.println("Первый метод сортировки массива. Основан на алгоритме сортировки вставками");
        MyArray arr1 = new MyArray(10);
        arr1.printArr(); System.out.println("\n");
        arr1.sort1();
        arr1.printArr(); System.out.println("\n");

        System.out.println("Второй метод сортировки массива. Время O(n)");
        MyArray arr2 = new MyArray(10);
        arr2.printArr(); System.out.println("\n");
        arr2.sort2();
        arr2.printArr(); System.out.println("\n");

        System.out.println("Сортировка столбцов матрицы по убыванию среднего значения");
        MyMatrix matr1 = new MyMatrix(3,4);
        matr1.printMatrix(); System.out.println("\n");
        matr1.sortColumns();
        matr1.printMatrix(); System.out.println("\n");

        System.out.println("Сортировка строк матрицы по возрастанию по самой длинной серии одинаковых элементов");
        int[][] a = {{0,0,2,3},{1,2,3,4},{0,1,1,1}};
        MyMatrix matr2 = new MyMatrix(a);
        matr2.printMatrix(); System.out.println("\n");
        matr2.sortLines();
        matr2.printMatrix(); System.out.println("\n");

        System.out.println("Вывод элементов матрицы по спирали");
        MyMatrix matr3 = new MyMatrix(5);
        matr3.printMatrix(); System.out.println("\n");
        matr3.specialPrint();
    }
}
