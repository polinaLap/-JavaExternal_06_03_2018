package com.company;
import java.util.Random;

//Массив целых чисел с двумя методами сортировки.
//Массив формируется случайно на отрезке [-range; range]
public class MyArray {
    private Random random = new Random();
    private static final int range = 50;
    private int[] arr;
    public  MyArray(int n){
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(range)*2-range;
        }
    }
    public void printArr(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //сортирует массив следующим образом: вначале отрицательные повозрастанию
    //затем положительные по убыванию. Основан на алгоритме сортировки вставками.Время O(n^2)
    public void sort1(){
        for (int i = 1; i <arr.length ; i++) {
            int j=i;
            int x =arr[i];
            if(arr[i]<0){
                while(j>0&&arr[j-1]>x){arr[j]=arr[j-1];j--;}
                arr[j]=x;
            }
            else{
                while(j>0&&arr[j-1]<x&&arr[j-1]>0){arr[j]=arr[j-1];j--;}
                arr[j]=x;
            }
        }
    }

    //сортирует массив следующим образом: сначала отрицательные,
    //затем положительные. Время O(n).

    public void sort2(){
        int indexPos=arr.length-1;
        int indexNeg=0;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0)res[indexNeg++]= arr[i];
            else res[indexPos--]=arr[i];
        }
        arr=res;
    }
}
