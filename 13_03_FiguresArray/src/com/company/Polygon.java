package com.company;
import java.util.Arrays;

public class Polygon extends Figure {
    private static final long serialVersionUID = 1L;
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

    public Point[] getPoints() {
        return points;
    }
}
