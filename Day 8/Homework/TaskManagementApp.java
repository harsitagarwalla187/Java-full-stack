import java.util.LinkedList;

class TaskManager {
     LinkedList<String> ll;

     TaskManager() {
          ll = new LinkedList<>();
     }

     public void addTask(String newTask) {
          ll.add(newTask);
     }

     public void removeTask(String completedTask) {
          ll.remove(completedTask);
     }

     public void showTasks() {
          System.out.println(ll);
     }
}


public class TaskManagementApp {
     public static void main(String[] args) {
          TaskManager tm = new TaskManager();

          tm.addTask("Buy Clothes");
          tm.addTask("Buy Biscuit");
          tm.addTask("Buy Milk");

          tm.showTasks();
          tm.removeTask("Buy Milk");
          tm.showTasks();
     }
}