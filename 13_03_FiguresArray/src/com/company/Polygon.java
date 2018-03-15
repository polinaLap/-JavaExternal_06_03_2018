package com.company;
import java.util.Arrays;

public class Polygon extends Figure {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }


    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
