package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Comparable<Task> {
    private int ID;
    private int arrivalTime;
    private AtomicInteger serviceTime;
    public Task(int ID, int arrivalTime,int serviceTime){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = new AtomicInteger(serviceTime);
    }
    public int getServiceTime(){
        return this.serviceTime.intValue();
    }
    public int getArrivalTime(){
        return this.arrivalTime;
    }
    public void setServiceTime(int serviceTime){
        this.serviceTime = new AtomicInteger(serviceTime);
    }
    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public String toString() {
            return "Task"+ ID +": arrivalTime: "+arrivalTime+ "   serviceTime: "+ serviceTime.intValue();
    }
    @Override
    public int compareTo(Task t) {
        return Integer.compare(this.arrivalTime, t.arrivalTime);
    }
}
