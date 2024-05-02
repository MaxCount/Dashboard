//package org.by.khomichenko;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class DashboardPanel extends JPanel {
//    public DashboardPanel() {
//        setLayout(new GridLayout(2, 1));
//
//        // Create parameter panels
//        JPanel parameterPanel1 = createParameterPanel("Parameter 1", "Value 1");
//        JPanel parameterPanel2 = createParameterPanel("Parameter 2", "Value 2");
//
//        // Add parameter panels to the dashboard
//        add(parameterPanel1);
//        add(parameterPanel2);
//    }
//
//    private JPanel createParameterPanel(String parameterName, String parameterValue) {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        panel.setBorder(BorderFactory.createTitledBorder(parameterName));
//
//        JLabel valueLabel = new JLabel(parameterValue);
//        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(valueLabel, BorderLayout.CENTER);
//
//        return panel;
//    }
//}