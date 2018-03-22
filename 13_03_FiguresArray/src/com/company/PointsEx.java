package com.company;

import javax.swing.*;

public class PointsEx extends JFrame {

    public PointsEx(Point[] points) {
        initUI(points);
    }

    private void initUI(Point[] points) {
        final Surface surface = new Surface(points);
        add(surface);

        setTitle("Points");
        setSize(500, 500);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
