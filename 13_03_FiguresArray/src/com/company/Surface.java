package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Surface extends JPanel implements ActionListener {

    private Point[] points;

    public Surface(Point[] points) {
        this.points=points;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);

        int w = getWidth();
        int h = getHeight();
        int i = 0;
        for (; i <points.length-1 ; i++) {
            g2d.drawLine(points[i].getX()*w/10,h-points[i].getY()*h/10-50,points[i+1].getX()*w/10,h-points[i+1].getY()*h/10-50);
        }
        g2d.drawLine(points[0].getX()*w/10,h-points[0].getY()*h/10-50,points[i].getX()*w/10,h-points[i].getY()*h/10-50);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
