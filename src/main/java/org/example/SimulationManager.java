package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationManager implements Runnable{
//    private int N = 10;
//    private int Q = 2;
//    private int tL= 60;
//    private int minArr = 2;
//    private int maxArr = 40;
//    private int minS = 2;
//    private int maxS = 4;
    private int N ;
    private int Q ;
    private int tL ;
    private int minArr ;
    private int maxArr ;
    private int minS ;
    private int maxS ;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private SimulationFrame frame;
    private SimulationView queues;
    private List<Task> generatedTasks;
    public SimulationManager(SimulationFrame frame, SimulationView queues){
        // frame = new SimulationFrame();

        this.frame = frame;
        this.queues = queues;
        this.N = frame.getN();
        this.Q = frame.getQ();
        this.tL = frame.getTimeLimit();
        this.minArr = frame.getMinArrTime();
        this.maxArr = frame.getMaxArrTime();
        this.minS = frame.getMinServiceTime();
        this.maxS = frame.getMaxServiceTime();
        for(int i = 0; i < Q; i++){
            Server server = new Server();
            Thread thread = new Thread(server);
            thread.start();

        }
        scheduler = new Scheduler(Q, 6);
        scheduler.changeStrategy(selectionPolicy);
        generateNRandomTasks();
    }
    private void generateNRandomTasks(){
        generatedTasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int processingTime = (int) (Math.random() * (maxS - minS) + minS);
            int arrivalTime = (int) (Math.random() * (maxArr-minArr)+ minArr);
            Task task = new Task(i,arrivalTime, processingTime);
            generatedTasks.add(task);
        }
        // sort the list of generated tasks by arrival time
        Collections.sort(generatedTasks);
    }
    @Override
    public void run() {
        int currentTime = 0;
        while (currentTime < tL) {

            // Dispatch tasks that have an arrival time equal to the current time
            for (Task task : generatedTasks) {
                if (task.getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(task);
                }
            }
            // Remove dispatched tasks from the generatedTasks list
            generatedTasks.removeIf(task -> task.getServiceTime() <= 0);
            try {
                File file = new File("output.txt");
                FileWriter writer = new FileWriter(file, true);
                List<Server> servers = scheduler.getServers();
                for (int i = 0; i < servers.size(); i++) {
                    Server server = servers.get(i);
                    writer.write("Server " + (i+1)+":\n");
                    Task[] task = server.getTasks();
                    for(int j = 0; j< task.length; j++){
                        writer.write(task[j].toString() + "\n");
                    }
                }
                writer.close();

                // Read the contents of the file and update the SimulationView
                String logText = new String(Files.readAllBytes(file.toPath()));
                queues.setSimArea(logText);
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }

            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            queues.refresh();
        }
    }


}
