package org.by.khomichenko;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        super("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        // Add tabs for pie chart, dashboard, and data input
        tabbedPane.addTab("Data Input", new DataInputPanel());
//        tabbedPane.addTab("Pie Chart", new PieChartPanel());
//        tabbedPane.addTab("Graph", new GraphExample();
//        tabbedPane.addTab("Dashboard", new DashboardPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
        });
    }
}
