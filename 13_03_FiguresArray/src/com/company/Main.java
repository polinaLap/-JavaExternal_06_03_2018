package com.company;


import java.io.InvalidObjectException;



public class Main {

    static  void testSerialiseFigureArray(){
        Point p1 = new Point(1,2);
        CPoint p2 = new CPoint(3,3,"yellow");
        Point p3 = new Point(5,7);
        /*Line AB = new Line(p1,p2);
        Line BC = new Line(p2,p3);
        Line AC = new Line(p1,p3);*/
        Triangle tr = new Triangle(p1,p2,p3);
        Line AB = tr.getAB();
        Line BC = tr.getBC();
        Line AC = tr.getAC();
        Figure[] arr = new Figure[7];
        arr[0]=p1;arr[1]=p2;arr[2]=p3;arr[3]=AB;arr[4]=BC;arr[5]=AC;arr[6]=tr;
        System.out.println("Figures before serialization");
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i].toString());
        }

        System.out.println("Figures after serialization");
        for (int i = 0; i <arr.length; i++) {
            String file = "figure"+i+".data";
            Serializator sz = new Serializator();
            sz.serialization(arr[i],file);
        }
        Figure[] resArr = new Figure[7];
        for (int i = 0; i <resArr.length ; i++) {
            resArr[i] = null;
            String file = "figure"+i+".data";
            Serializator sz = new Serializator();
            try{
                resArr[i] = sz.deserialization(file);
                System.out.println(resArr[i]);

            }catch (InvalidObjectException e){
                e.printStackTrace();
            }
        }

    }

    static void drawPolygon(Polygon pol){
                PointsEx ex = new PointsEx(pol.getPoints());
                ex.setVisible(true);
    }
    static  void testSerialisePolygons(){
        Polygon pol1= new Polygon(new Point[]{new Point(2,1), new Point(2,5), new Point(5,7), new Point(8,5),new Point(8,1)});
        Polygon pol2= new Polygon(new Point[]{new Point(2,1), new Point(4,3), new Point(2,3), new Point(5,6),new Point(8,3),new Point(6,3),new Point(8,1)});
        Polygon pol3= new Polygon(new Point[]{new Point(2,2), new Point(1,4), new Point(2,6), new Point(5,6),new Point(6,4),new Point(5,2)});
        Figure[] arr = new Figure[3];
        arr[0]=pol1;arr[1]=pol2;arr[2]=pol3;
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i].toString());
        }

        for (int i = 0; i <arr.length; i++) {
            String file = "polygon"+i+".data";
            Serializator sz = new Serializator();
            sz.serialization(arr[i],file);
        }
        Figure[] resArr = new Figure[3];
        for (int i = 0; i <resArr.length ; i++) {
            resArr[i] = null;
            String file = "polygon"+i+".data";
            Serializator sz = new Serializator();
            try{
                resArr[i] = sz.deserialization(file);
                System.out.println(resArr[i]);


            }catch (InvalidObjectException e){
                e.printStackTrace();
            }
            if(resArr[i] instanceof com.company.Polygon)
                drawPolygon((Polygon)resArr[i]);
        }

    }
    public static void main(String[] args) {
        //testSerialiseFigureArray();
        testSerialisePolygons();
        /*Point A = new Point(1,2);
        CPoint B = new CPoint(3,3,"yellow");
        Point C = new Point(5,7);
        Line AB = new Line (A,B);
        Line EK = new CLine(new Point(-2,8), new Point(0,9),"red");
        Triangle tr = new Triangle(A,B,C);
        Polygon pol= new Polygon(new Point[]{new Point(2,1), new Point(2,5), new Point(5,7), new Point(8,5),new Point(8,1)});
       */
        /*Figure[] arr = new Figure[7];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = AB;
        arr[4] = EK;
        arr[5] = tr;
        arr[6] = pol;
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i].toString());
        }*/

    }
}
