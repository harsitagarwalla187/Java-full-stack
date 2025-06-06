import java.util.concurrent.*;

public class CallableExample {
    public static  void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newFixedThreadPool(4);

        Callable<String> callable = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Task 3 by " + Thread.currentThread().getName());
            }

            return "This is Callable Interface!";
        };

        Future<String> val =  service.submit(callable);
        System.out.println("Callable value: " + val.get());

        service.shutdown();
    }
}
