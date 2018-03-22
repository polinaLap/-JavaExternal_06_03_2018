package com.company;
public class CPoint extends Point {
    private static final long serialVersionUID = 1L;
    private String color;

    public CPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }


    @Override
    public String toString() {
        return "CPoint{x = " +getX()+",y= "+getY()+
                ", color='" + color  + '\''+
                '}';
    }
}
