package com.company;

public abstract class Vehicle {
    private double x, y;
    private double price,speed;
    private int year;
    public Vehicle(double x, double y, double price, double speed, int year){
        this.x=x;
        this.y=y;
        this.price=price;
        this.speed=speed;
        this.year=year;
    }
    public Vehicle(){
        this(0,0,0,0,0);
    }

    @Override
    public abstract String toString();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getPrice() {
        return price;
    }

    public double getSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }
}
