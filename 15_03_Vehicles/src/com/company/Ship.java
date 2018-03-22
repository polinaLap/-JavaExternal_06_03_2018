package com.company;

public class Ship extends Vehicle implements ISwim {
    @Override
    public void swim() {
        System.out.println("Ship swim");
    }

    private int pasCount;
    private String port;

    private Screws screws;
    public Screws getScrews() { return screws; }
    public Ship(double x, double y, double price, double speed, int year, int pasCount, String port) {
        super(x, y, price, speed, year);
        this.pasCount=pasCount;
        this.port=port;
        if(year<2012) screws= Screws.TYPE1;
        else if(year<2015) screws= Screws.TYPE2;
        else screws= Screws.TYPE3;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "pasCount=" + pasCount +
                ", port='" + port + '\'' +
                ", x=" + getX() +
                ", y=" + getY() +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", year=" + getYear() +
                '}';
    }

    public int getPasCount() {
        return pasCount;
    }

    public String getPort() {
        return port;
    }
    public class Engine  extends Vehicle.Engine{
        public Engine(int type){
            this.type=type;
            Ship.this.setSpeed(Ship.this.getSpeed()+20*type);
            Ship.this.setPrice(Ship.this.getPrice()+200*type);
        }
    }

    public static enum Screws{
        TYPE1,TYPE2, TYPE3
    }
}
