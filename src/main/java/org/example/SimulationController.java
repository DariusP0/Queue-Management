package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationController {
    private SimulationFrame frame;
    private SimulationView queuesView;

    public SimulationController(SimulationFrame frame, SimulationView queuesView) {
        this.frame = frame;
        this.queuesView = queuesView;
        this.frame.addButtonListener(new Simulation());
    }

    class Simulation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (frame.getN() <= 0 || frame.getQ() <= 0 || frame.getTimeLimit() <= 0 || frame.getMinArrTime() < 0 || frame.getMaxArrTime() < frame.getMinArrTime() || frame.getMinServiceTime() < 0 || frame.getMaxServiceTime() < frame.getMinServiceTime()) {
                JOptionPane.showMessageDialog(frame, "Invalid input values!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                frame.setVisible(false);
                queuesView.setVisible(true);
                SimulationManager simulationManager = new SimulationManager(frame, queuesView);
                Thread mainThread = new Thread(simulationManager);
                mainThread.start();
            }
        }
    }
}
