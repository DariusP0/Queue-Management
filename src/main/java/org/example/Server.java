package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    public Server(){
        this.tasks = new LinkedBlockingQueue<>() ;
        this.waitingPeriod = new AtomicInteger();
    }
    public void addTask(Task task){
        tasks.add(task);
        waitingPeriod.incrementAndGet();
    }
    public void run() {
        while(true) {
            try {
                Task newTask = tasks.peek();
                if(newTask!=null){
                    while(newTask.getServiceTime()>0){
                        Thread.sleep(1000);
                        newTask.setServiceTime(newTask.getServiceTime()-1);
                        waitingPeriod.decrementAndGet();
                    }
                    tasks.take();

                }
                else{Thread.sleep(1000);}
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public Task[] getTasks(){
        Task[] task = new Task[tasks.size()];
        tasks.toArray(task);
        return task;
    }

    public int getProcessTime(){
        int sum = 0;
        for(Task task:tasks){
            sum+=task.getServiceTime();
        }
        return sum;
    }
}
