import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newFixedThreadPool(1);

        Callable<Integer> callable = () -> {
            return 10 + 15;
        };

        Future<Integer> sum = service.submit(callable);
        System.out.println("Sum of 10 & 15 : " + sum.get());
        service.shutdown();

    }
}
