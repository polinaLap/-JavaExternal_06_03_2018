package com.company;

public class Triangle extends Figure {
    private static final long serialVersionUID = 1L;
    private Point a, b, c;
    private Line ab, ac, bc;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Line getAB(){
        if(ab==null){
            ab = new Line(a,b);}
        return ab;
    }
    public Line getAC(){
        if(ac==null){
            ac = new Line(a,c);}
        return ac;
    }
    public Line getBC(){
        if(bc==null){
            bc = new Line(b,c);}
        return bc;
    }

    @Override
    public String toString() {
        String res= "Triangle{" +
                "A=" + a +
                ", B=" + b +
                ", C=" + c;
        if(ab!=null) res+="AB="+ab;
        if(bc!=null) res+="BC="+bc;
        if(ac!=null) res+="AC="+ac;
        res+='}';
        return res;
    }
}
