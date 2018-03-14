package com.company;

import java.util.Random;

public class MyMatrix {
    private Random random = new Random();
    private static final int range = 10;
    private int[][] matrix;
    private int n;
    private int m;
    public MyMatrix(int n,int m){
        matrix = new int[n][m];
        this.n=n;
        this.m=m;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                matrix[i][j]= random.nextInt(range)*2-range;
            }
    }
    public MyMatrix(int[][]matrix){
        this.matrix=matrix;
        m=matrix[0].length;
        n=matrix.length;
    }
    public MyMatrix(int n){
        this(n,n);
    }
    public void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%4s",matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    //сортирует столбцы по убыванию среднего значения. Основан на сортировке пузырьком
    public void sortColumns(){
        for (int i = 1; i <m ; i++) {
            boolean cont = false;
            for (int j = 0; j <m-i ; j++) {
                if(averageValue(j)<averageValue(j+1)) {swapColumns(j,j+1); cont=true;}
            }
            if(!cont) break;
        }
    }
    //меняет местами i,j-е колонки  матрицы
    private void swapColumns(int i,int j){
        for (int k = 0; k < n; k++) {
            int tmp =matrix[k][i];
            matrix[k][i]=matrix[k][j];
            matrix[k][j]=tmp;
        }
    }
    //возвращает среднее значение колонки с индексом columnPos
    private double averageValue(int columnPos){
        double res=0;
        for (int i = 0; i < n; i++) {res+=matrix[i][columnPos];}
        return res/n;
    }

    //сортирует строки, по возрастанию по самой длинной серии одинаковых элементов.
    // Основан на сортировке пузырьком
    public void sortLines(){
        for (int i = 1; i <n ; i++) {
            boolean cont = false;
            for (int j = 0; j <n-i ; j++) {
                if(maxCountSubCons(j)>maxCountSubCons(j+1)) {swapLines(j,j+1); cont=true;}
            }
            if(!cont) break;
        }
    }

    //возвращает длину самой длинной серии одинаковых элементов строки с индексом numLine
    private int maxCountSubCons(int numLine){
        int maxLength=0;
        for (int i = 1; i < m; i++) {
            if(matrix[numLine][i]==matrix[numLine][i-1]){
                int length=2;
                while (i<m-1&&matrix[numLine][i]==matrix[numLine][++i]) length++;
                if(maxLength<length)maxLength=length;
            }
        }
        return maxLength;
    }
    private void swapLines(int i, int j){
        int[] tmp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tmp;
    }

    //Выводит матрицу в строку, читая ее по спирали
    public void specialPrint(){
        if(n%2==0) {System.out.println("Четная размерность матрицы! Вывод по спирали не предусмотрен."); return;}
        int numNotPrintedLines=n;
        int numNotPrintedColumns=n;
        int lineNum=0;
        int columnNum=n-1;
        int direction= 1; //по линии вправо 1, по линии влево 2, по столбцу вниз -1, по столбцу вверх -2
        while (numNotPrintedLines>0&&numNotPrintedColumns>0){
            if(direction>0){
                if(direction==1){
                    for (int i = lineNum; i <n-lineNum ; i++) {
                        System.out.print(matrix[lineNum][i]+" ");
                    }
                    direction=-1;
                }
                else {
                    for (int i = lineNum-1; i >=n-lineNum-1 ; i--) {
                        System.out.print(matrix[lineNum][i]+" ");
                    }
                direction=-2;
                }
                numNotPrintedLines--;
                lineNum=n-lineNum;
                if(numNotPrintedLines%2==0)lineNum--;

            }
            else {
                if(direction==-1){
                    for (int i = n-columnNum; i <=columnNum ; i++) {
                        System.out.print(matrix[i][columnNum]+" ");
                    }
                    direction=2;
                }
                else{
                    for (int i = n-columnNum-2; i >columnNum ; i--) {
                        System.out.print(matrix[i][columnNum]+" ");
                    }
                    direction=1;
                }
                numNotPrintedColumns--;
                columnNum=n-columnNum-1;
                if(numNotPrintedColumns%2==1)columnNum--;

            }
        }

    }
}
