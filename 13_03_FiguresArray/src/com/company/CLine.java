package com.company;
public class CLine extends Line {
    private static final long serialVersionUID = 1L;
    private String color;

    public CLine(Point begin, Point end, String color) {
        super(begin, end);
        this.color = color;
    }

    @Override
    public String toString() {
        return "CLine{begin="+ getBegin() +
                ", end=" + getEnd() +
                ",color='" + color + '\''+
                '}';
    }
}

