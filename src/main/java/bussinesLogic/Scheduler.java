package bussinesLogic;

import Strategy.ConcreteStrategyQueue;
import Strategy.ConcreteStrategyTime;
import Strategy.SelectionPolicy;
import Strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;
    public Scheduler(int maxNoServers, int maxTasksPerServer){
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        this.servers = new ArrayList<>();
        for(int i = 0; i<maxNoServers;i++){
            Server server = new Server();
            Thread thread = new Thread(server);
            servers.add(server);
            thread.start();
        }
    }
    public void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }
    public void dispatchTask(Task t){
        if (t == null) {
            System.out.println("Error: Task is null");
            return;
        }
        if (strategy == null) {
            System.out.println("Error: Strategy is null");
            return;
        }
        strategy.addTask(servers,t);
    }
    public List<Server> getServers(){
        return servers;
    }
}
