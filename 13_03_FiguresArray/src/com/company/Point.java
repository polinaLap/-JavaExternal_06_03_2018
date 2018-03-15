package com.company;

public class Point extends Figure{
    private int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Point(){
        this(0,0);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
