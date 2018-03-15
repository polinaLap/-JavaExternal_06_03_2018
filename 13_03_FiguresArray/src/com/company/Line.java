package com.company;
public class Line extends Figure {
    private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }
}
