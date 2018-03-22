package com.company;

public class Plane extends Vehicle implements IFly{
    private double height;
    private int pasCount;

    private Tail tail;
    public Tail getTail() { return tail; }
    public Plane(double x, double y, double price, double speed, int year, int pasCount,int height) {
        super(x, y, price, speed, year);
        this.height=height;
        this.pasCount=pasCount;
        if(speed<200) tail=Tail.TYPE1;
        else if(speed<400) tail=Tail.TYPE2;
        else tail=Tail.TYPE3;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "height=" + height +
                ", pasCount=" + pasCount +
                ", x=" + getX() +
                ", y=" + getY() +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", year=" + getYear() +
                '}';
    }

    public double getHeight() {
        return height;
    }

    public int getPasCount() {
        return pasCount;
    }

    @Override
    public void fly() {
        System.out.println("Plane fly");
    }

    public class Engine  extends Vehicle.Engine{
        public Engine(int type){
            this.type=type;
            Plane.this.setSpeed(Plane.this.getSpeed()+30*type);
            Plane.this.setPrice(Plane.this.getPrice()+300*type);
        }
    }

    public static enum Tail{
        TYPE1,TYPE2,TYPE3;
    }
}
