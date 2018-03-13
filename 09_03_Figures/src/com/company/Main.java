package com.company;

public class Main {

    public static int width = 10;
    public static void drawRectangle(){
        for (int i = 0; i <width ; i++) {
            for (int j = 0; j <width ; j++) {
                if(i==0||j==0||i==width-1||j==width-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    public static void drawRightTriangle(){
        for (int i = 0; i <width ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(j==0||i==j||i==width-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    public static void drawEquilateralTriangle(){
        int placeToDraw = width/2+1;
        if(width%2==0) width++;
        for (int i = 0; i <=width/2+1 ; i++) {
            for (int j = 0; j <=placeToDraw ; j++) {
                if(i==0&&j==placeToDraw) System.out.print("*");
                else if(i!=0&&(j==placeToDraw||j==width-placeToDraw+1)) System.out.print("*");
                else if(i==width/2+1) System.out.print("*");
                else System.out.print(" ");
            }
            placeToDraw++;
            System.out.print("\n");
        }
    }
    public static void drawRomb(){
        int placeToDraw = width/2+1;
        if(width%2==0) width++;
        for (int i = 0; i <=width+1 ; i++) {
            for (int j = 0; j <=placeToDraw ; j++) {
                if((i==0||i==width+1)&&j==placeToDraw) System.out.print("*");
                else if(i!=0&&(j==placeToDraw||j==width-placeToDraw+1)) System.out.print("*");
                else System.out.print(" ");
            }
            if(i<width/2+1)placeToDraw++;
            else placeToDraw--;
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        drawRectangle();
        drawRightTriangle();
        drawEquilateralTriangle();
        drawRomb();
    }
}

