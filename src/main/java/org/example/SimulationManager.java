package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationManager implements Runnable{
    private int N = 10;
    private int Q = 2;
    private int tL= 60;
    private int minArr = 2;
    private int maxArr = 40;
    private int minS = 2;
    private int maxS = 4;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private SimulationFrame frame;
    private List<Task> generatedTasks;
    public SimulationManager(){

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
            List<Server> servers = scheduler.getServers();
            for (int i = 0; i < servers.size(); i++) {
                Server server = servers.get(i);
                System.out.println("Server " + (i+1)+": ");
                Task[] task = server.getTasks();
                for(int j = 0; j< task.length; j++){
                    System.out.println(task[j]);
                }
            }
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
    public static void main(String[] args) {
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        t.start();
    }
}
