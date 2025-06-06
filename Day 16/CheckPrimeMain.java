import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Example implements Callable<List<String>> {
    List<Integer> list;

    Example(List<Integer> list) {
        this.list = list;
    }

    boolean isPrime(int num) {
        for(int i=2; i<num; i++) {
            if(num%i == 0)
                return false;
        }
        return true;
    }

    @Override
    public List<String> call() throws Exception {

        List<String> res = new ArrayList<>();

        for(Integer i:list) {
            if(isPrime(i)) {
                res.add(i + " is Prime.");
            } else {
                res.add(i + " is not Prime.");
            }
        }

        return res;
    }
}

public class CheckPrimeMain {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<List<String>> f1 = service.submit(new Example(Arrays.asList(1,2,3,4,5,6,7)));
        Future<List<String>> f2 = service.submit(new Example(Arrays.asList(11, 23, 65, 78)));

        System.out.println(f1.get());
        System.out.println(f2.get());

        service.shutdown();

    }
}
