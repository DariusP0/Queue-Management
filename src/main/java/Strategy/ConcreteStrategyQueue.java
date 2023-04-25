package Strategy;

import bussinesLogic.Server;
import bussinesLogic.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task T){
        int minQ = servers.get(0).getTasks().length;
        Server min = null;

        for(Server server : servers){
            if(minQ > server.getTasks().length) {
                minQ = server.getTasks().length;
                min = server;
            }
            min.addTask(T);
        }
    }
}
