package org.by.khomichenko;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.util.ArrayList;

public class GraphExample extends JPanel {

    public GraphExample(ArrayList<Double> coe) {
//        setTitle("График зависимости");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);


        if (coe != null) {
            // Создание набора данных
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(Double i: coe) {
                dataset.addValue(i, "value", String.valueOf(coe.indexOf(i)));
                System.out.println(i);
            }

            // Создание графика
            JFreeChart chart = ChartFactory.createBarChart(
                    "График зависимости",
                    "Параметр",
                    "Значение",
                    dataset,
                    PlotOrientation.VERTICAL,
                    false, true, false
            );

            // Добавление графика на панель
            ChartPanel chartPanel = new ChartPanel(chart);
            add(chartPanel);
        } else {
            JOptionPane.showMessageDialog(this, "Введите другие параметры", "Message", JOptionPane.INFORMATION_MESSAGE);

        }

    }

//    public GraphExample() {
//        setTitle("График зависимости");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(600, 400);
//
//        // Создание набора данных
//        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
//
//        // Создание серии данных
//        XYSeries series1 = new XYSeries("Серия 1", true,false);
//        series1.add(1.0, 1.0);
//        series1.add(2.0, 4.0);
//        dataset.addSeries(series1);
//
//        // Создание графика
//        JFreeChart chart = ChartFactory.createXYLineChart(
//                "График зависимости",
//                "X",
//                "Y",
//                dataset
//        );
//
//        // Добавление графика на панель
//        ChartPanel chartPanel = new ChartPanel(chart);
//        add(chartPanel);
//    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new GraphExample().setVisible(true);
//        });
//    }
}