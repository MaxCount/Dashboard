//package org.by.khomichenko;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.data.general.PieDataset;
//
//import javax.swing.*;
//
//public class PieChartPanel extends JPanel {
//    public PieChartPanel() {
//        PieDataset dataset = createDataset();
//        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset);
//        ChartPanel chartPanel = new ChartPanel(chart);
//        add(chartPanel);
//    }
//
//    private PieDataset createDataset() {
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        dataset.setValue("Category 1", 20);
//        dataset.setValue("Category 2", 30);
//        dataset.setValue("Category 3", 50);
//        return dataset;
//    }
//}