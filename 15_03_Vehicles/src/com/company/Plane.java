package com.company;

public class Plane extends Vehicle{
    private double height;
    private int pasCount;

    public Plane(double x, double y, double price, double speed, int year, int pasCount,int height) {
        super(x, y, price, speed, year);
        this.height=height;
        this.pasCount=pasCount;
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
                ", year=" + getSpeed() +
                '}';
    }

    public double getHeight() {
        return height;
    }

    public int getPasCount() {
        return pasCount;
    }
}
