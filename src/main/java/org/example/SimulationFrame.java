package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {

    private JFrame frame;

    private JLabel lblClients, lblQueues, lblSimulationInterval, lblMinArrivalTime, lblMaxArrivalTime,
            lblMinServiceTime, lblMaxServiceTime;
    private JTextField txtClients, txtQueues, txtSimulationInterval, txtMinArrivalTime, txtMaxArrivalTime,
            txtMinServiceTime, txtMaxServiceTime;
    private JButton startButton;
    private int N, Q, timeLimit, minArrTime, maxArrTime, minServiceTime, maxServiceTime;

    public SimulationFrame() {

        frame = new JFrame("Input Data");

        lblClients = new JLabel("Clients:");
        txtClients = new JTextField(5);
        lblQueues = new JLabel("Queues:");
        txtQueues = new JTextField(5);
        lblSimulationInterval = new JLabel("Max interval:");
        txtSimulationInterval = new JTextField(5);
        lblMinArrivalTime = new JLabel("Min arrival:");
        txtMinArrivalTime = new JTextField(5);
        lblMaxArrivalTime = new JLabel("Max arrival:");
        txtMaxArrivalTime = new JTextField(5);
        lblMinServiceTime = new JLabel("Min service:");
        txtMinServiceTime = new JTextField(5);
        lblMaxServiceTime = new JLabel("Max service:");
        txtMaxServiceTime = new JTextField(5);
        startButton = new JButton("START");

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(lblClients);
        panel.add(txtClients);
        panel.add(lblQueues);
        panel.add(txtQueues);
        panel.add(lblSimulationInterval);
        panel.add(txtSimulationInterval);
        panel.add(lblMinArrivalTime);
        panel.add(txtMinArrivalTime);
        panel.add(lblMaxArrivalTime);
        panel.add(txtMaxArrivalTime);
        panel.add(lblMinServiceTime);
        panel.add(txtMinServiceTime);
        panel.add(lblMaxServiceTime);
        panel.add(txtMaxServiceTime);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 200);
    }

    public int getN() {
        return Integer.parseInt(txtClients.getText());
    }

    public int getQ() {
        return Integer.parseInt(txtQueues.getText());
    }

    public int getTimeLimit() {
        return Integer.parseInt(txtSimulationInterval.getText());
    }

    public int getMaxArrTime() {
        return Integer.parseInt(txtMaxArrivalTime.getText());
    }

    public int getMinArrTime() {
        return Integer.parseInt(txtMinArrivalTime.getText());
    }

    public int getMinServiceTime() {
        return Integer.parseInt(txtMinServiceTime.getText());
    }

    public int getMaxServiceTime() {
        return Integer.parseInt(txtMaxServiceTime.getText());
    }

    public void addButtonListener(ActionListener action) {
        startButton.addActionListener(action);
    }
}
