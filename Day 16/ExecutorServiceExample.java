import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);

        Runnable task1 = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Task 1 by " + Thread.currentThread().getName());
            }
        };
        Runnable task2 = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Task 2 by " + Thread.currentThread().getName());
            }
        };

        service.execute(task1);
        service.execute(task2);

        service.shutdown();
    }
}
