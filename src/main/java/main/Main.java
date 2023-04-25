package main;

import GUI.SimulationController;
import GUI.SimulationFrame;
import GUI.SimulationView;

public class Main {
    public static void main(String[] args) {
        SimulationView queues = new SimulationView();
        SimulationFrame frame = new SimulationFrame();
        SimulationController Controller = new SimulationController(frame, queues);
    }
}
