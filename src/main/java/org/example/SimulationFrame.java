package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class SimulationFrame extends JFrame {

        private JFrame frame;

        private JLabel lblClients;
        private JTextField txtClients;
        private JLabel lblQueues;
        private JTextField txtQueues;
        private JLabel lblSimulationInterval;
        private JTextField txtSimulationInterval;

        private JLabel lblMinArrivalTime;
        private JTextField txtMinArrivalTime;
        private JLabel lblMaxArrivalTime;
        private JTextField txtMaxArrivalTime;

        private JLabel lblMinServiceTime;
        private JTextField txtMinServiceTime;
        private JLabel lblMaxServiceTime;
        private JTextField txtMaxServiceTime;
        private JButton startButton;
        private int N,Q,timeLimit, minArrTime,maxArrTime,minServiceTime,maxServiceTime;
        public SimulationFrame() {

            frame = new JFrame("Input Data");

            lblClients = new JLabel("Clients:");
            txtClients = new JTextField(5);
            lblQueues = new JLabel("Queues:");
            txtQueues = new JTextField(5);
            lblSimulationInterval = new JLabel("Max sim. interval :");
            txtSimulationInterval = new JTextField(5);
            lblMinArrivalTime = new JLabel("Min arr time:");
            txtMinArrivalTime = new JTextField(5);
            lblMaxArrivalTime = new JLabel("Max arr time:");
            txtMaxArrivalTime = new JTextField(5);
            lblMinServiceTime = new JLabel("Min service time:");
            txtMinServiceTime = new JTextField(5);
            lblMaxServiceTime = new JLabel("Max service time:");
            txtMaxServiceTime = new JTextField(5);
            startButton = new JButton("START");


            JPanel panel = new JPanel(new GridLayout(8, 2));
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
            panel.add(startButton);

            frame.add(panel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(640, 480);


        }

        public int getN(){
            return Integer.parseInt(txtClients.getText());
        }
        public int getQ(){
            return Integer.parseInt(txtQueues.getText());
        }
        public int getTimeLimit(){
            return Integer.parseInt(txtSimulationInterval.getText());
        }
        public int getMaxArrTime(){
            return Integer.parseInt(txtMaxArrivalTime.getText());
        }
        public int getMinArrTime(){
            return Integer.parseInt(txtMinArrivalTime.getText());
        }
        public int getMinServiceTime(){
            return Integer.parseInt(txtMinServiceTime.getText());
        }
        public int getMaxServiceTime(){
            return Integer.parseInt(txtMaxServiceTime.getText());
        }
        public void addButtonListener(ActionListener action) {
            startButton.addActionListener(action);
        }
//        public static void main(String[] args) {
////            SimulationFrame inputView = new SimulationFrame();
////            if(inputView.start()==1){
////            SimulationManager gen = new SimulationManager(inputView);
////            Thread t = new Thread(gen);
////            t.start();
////                //
//            }
    }


