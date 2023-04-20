package org.example;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addTask(List<Server> servers,Task T){
        int minTime = servers.get(0).getProcessTime();
        Server min = servers.get(0);

       for(Server server : servers){
           if(minTime > server.getProcessTime()) {
               minTime = server.getProcessTime();
               min = server;
           }
       }
        min.addTask(T);
    }
}
