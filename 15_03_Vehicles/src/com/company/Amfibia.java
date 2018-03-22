package com.company;

public class Amfibia extends Car implements ISwim {

    private Screws screws;
    public Screws getScrews() { return screws; }
    public Amfibia(double x, double y, double price, double speed, int year) {
        super(x, y, price, speed, year);
        if(year<2012) screws= Screws.TYPE1;
        else if(year<2015) screws= Screws.TYPE2;
        else screws= Screws.TYPE3;
    }

    @Override
    public void move() {
        System.out.println("Amfibia move");
    }

    @Override
    public void swim() {
        System.out.println("Amfibia swim");
    }

    @Override
    public String toString() {
        return "Amfibia{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", year=" + getYear() +
                '}';
        }

    public static enum Screws{
        TYPE1,TYPE2, TYPE3
    }
    public class Engine  extends Vehicle.Engine{
        public Engine(int type){
            this.type=type;
            Amfibia.this.setSpeed(Amfibia.this.getSpeed()+5*type);
            Amfibia.this.setPrice(Amfibia.this.getPrice()+100*type);
        }
    }
}
