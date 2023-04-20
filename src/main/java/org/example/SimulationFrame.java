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



            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    start();
                }
            });

        }

        public void run() {
            setVisible(true);
        }

        public void start() {
            N = Integer.parseInt(txtClients.getText());
            Q = Integer.parseInt(txtQueues.getText());
            timeLimit = Integer.parseInt(txtSimulationInterval.getText());
            maxArrTime = Integer.parseInt(txtMaxArrivalTime.getText());
            minArrTime = Integer.parseInt(txtMinArrivalTime.getText());
            minServiceTime = Integer.parseInt(txtMinServiceTime.getText());
            maxServiceTime = Integer.parseInt(txtMaxServiceTime.getText());

            //
        }
        public int getN(){
            return this.N;
        }
        public int getQ(){
            return this.Q;
        }
        public int getTimeLimit(){
            return this.timeLimit;
        }
        public int getMaxArrTime(){
            return this.maxArrTime;
        }
        public int getMinArrTime(){
            return this.minArrTime;
        }
        public int getMinServiceTime(){
            return this.minServiceTime;
        }
        public int getMaxServiceTime(){
            return this.maxServiceTime;
        }


    }

