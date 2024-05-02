//package org.by.khomichenko;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class BirthRateGraph extends JPanel {
//
//    private int[] birthRates = { 10, 15, 20, 25, 30,35,40,45,50,55,60 };
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        // Set up the axes
//        g.drawLine(50, 250, 450, 250); // X-axis
//        g.drawLine(50, 250, 50, 50);   // Y-axis
//
//        // Plot the birth rate data points
//        int x = 50;
//        int y = 250;
//        int prevX = x;
//        int prevY = y;
//        for (int i = 0; i < birthRates.length; i++) {
//            x += 20; // Increase x position for each data point
//            y = 250 - birthRates[i]; // Invert y position for graph
//            g.drawLine(prevX, prevY, x, y);
//            prevX = x;
//            prevY = y;
//        }
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Birth Rate Graph");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 300);
//        frame.add(new BirthRateGraph());
//        frame.setVisible(true);
//    }
//}