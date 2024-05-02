package org.by.khomichenko;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DataInputPanel extends JPanel {

    public DataInputPanel() {
        setLayout(new GridLayout(6, 2));

        // Create input fields
        JTextField inputField1 = new JTextField(5);
        JTextField inputField2 = new JTextField(5);
        JTextField inputField3 = new JTextField(5);
        JTextField inputField4 = new JTextField(5);
        JTextField inputField5 = new JTextField(5);
        JTextField inputField6 = new JTextField(5);

        // Create labels
        JLabel label1 = new JLabel("Ub:");
        JLabel label2 = new JLabel("U0:");
        JLabel label3 = new JLabel("Um:");
        JLabel label4 = new JLabel("Omega:");
        JLabel label5 = new JLabel("a:");
        JLabel label6 = new JLabel("k:");

        JPanel block1 = new JPanel();
        block1.add(label1);
        block1.add(label2);
        block1.add(label3);
        block1.add(label4);
        block1.add(label5);
        block1.add(label6);
        add(block1);

        // Create button
        JButton submitButton = new JButton("Submit");

        // Add components to the panel
        JPanel inputPanel1 = new JPanel(new FlowLayout());
        inputPanel1.add(label1);
        inputPanel1.add(inputField1);
//        inputPanel1.setBorder(new EmptyBorder(100, 100, 100, 100)); // Add padding to the left and right

        JPanel inputPanel2 = new JPanel(new FlowLayout());
        inputPanel2.add(label2);
        inputPanel2.add(inputField2);

        JPanel inputPanel3 = new JPanel(new FlowLayout());
        inputPanel3.add(label3);
        inputPanel3.add(inputField3);

        JPanel inputPanel4 = new JPanel(new FlowLayout());
        inputPanel4.add(label4);
        inputPanel4.add(inputField4);

        JPanel inputPanel5 = new JPanel(new FlowLayout());
        inputPanel5.add(label5);
        inputPanel5.add(inputField5);

        JPanel inputPanel6 = new JPanel(new FlowLayout());
        inputPanel6.add(label6);
        inputPanel6.add(inputField6);

        add(inputPanel1);
        add(inputPanel2);
        add(inputPanel3);
        add(inputPanel4);
        add(inputPanel5);
        add(inputPanel6);
        add(submitButton);

        submitButton.addActionListener(e -> {
            // Get the text from the JTextField
            Double Ub = Double.parseDouble(inputField1.getText());
            Double U0 = Double.parseDouble(inputField2.getText());
            Double Um = Double.parseDouble(inputField3.getText());
            Double Omega = Double.parseDouble(inputField4.getText());
            Double a = Double.parseDouble(inputField5.getText());
            Double k = Double.parseDouble(inputField6.getText());
            // Display the text in a message dialog
            JOptionPane.showMessageDialog(this,new GraphExample(calculateCoefficient(U0,Um,Ub,a,Omega,k, 20.0)));
        });
    }

    private Double calculateGamma(Double Um, Double Ub) {
        return Um/Ub;
    }
    private Double calculateBetta(Double U0, Double Ub) {
        return U0/Ub;
    }
    private Double calculateB(Double betta, Double gamma, Double a) {
        return (1-Math.pow(betta, a))/(a*gamma*Math.pow(betta, a-1));
    }
    private Double calculateTetta(Double b) {
        if (b - Math.pow(Math.pow(b,2)-1,0.5) < 1) {
            return b - Math.pow(Math.pow(b,2)-1,0.5);
        } else {
            System.out.println("no");
            return null;
        }
    }
    private Double calculateW(Double a, Double gamma, Double betta) {
        return 1/(a*gamma*Math.pow(betta,a-1));
    }
    private Double calculateM(Double w, Double tetta) {
        try {
            return (2*w*tetta)/(1-Math.pow(tetta,2)); // 1
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Double> calculateCoefficient(Double Uo, Double Um, Double Ub, Double a, Double omegaM, Double k, Double t) {
            ArrayList<Double> list = new ArrayList<>();
        for (int h = 0; h < k; h++) {
            try {
                list.add(calculateM(calculateW(a,calculateGamma(Um, Ub),calculateBetta(Uo,Ub)), calculateTetta(calculateB(calculateBetta(Uo,Ub), calculateGamma(Um, Ub),a))) *
                        (1 + 2 * cos(Uo,Um,Ub,a,omegaM,h)));
            } catch (Exception e) {
                return null;
            }
        }
             return list;
    }
    private Double cos(Double Uo, Double Um, Double Ub, Double a, Double omegaM, Integer k) {
        double sum = 0.0;
        for (int i = 1; i <= k+1; i++) {
            sum = sum + Math.pow(calculateTetta(calculateB(calculateBetta(Uo, Ub), calculateGamma(Um, Ub), a)),k)
                    * Math.cos(i * omegaM * 100);
            System.out.println(Math.cos(i * omegaM * 100));
        }
        return sum;
    }
}