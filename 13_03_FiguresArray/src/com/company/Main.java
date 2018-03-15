package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Point A = new Point(1,2);
        CPoint B = new CPoint(3,3,"yellow");
        Point C = new Point(5,7);
        Line AB = new Line (A,B);
        Line EK = new CLine(new Point(-2,8), new Point(0,9),"red");
        Triangle tr = new Triangle(A,B,C);
        Polygon pol= new Polygon(new Point[]{new Point(-2,8), new Point(-2,10), new Point(0,10), new Point(0,8)});
        Figure[] arr = new Figure[7];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = AB;
        arr[4] = EK;
        arr[5] = tr;
        arr[6] = pol;
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i].toString());
        }

    }
}
