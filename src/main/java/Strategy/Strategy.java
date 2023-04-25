package Strategy;

import bussinesLogic.Server;
import bussinesLogic.Task;

import java.util.List;

public interface Strategy {
    public void addTask(List<Server>servers, Task T);
}
