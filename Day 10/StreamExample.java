import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
     public static void main(String[] args) {

          List<Integer> arr = List.of(54, 32, 43, 23, 26, 57);
          // Stream<Integer> stream = arr.stream();

          // System.out.println("List Elements: " + arr);
          // System.out.println("Stream Elements: ");
          // stream.forEach(ns -> System.out.println(ns));
          // stream.forEach(System.out::println);

          // Stream<Integer> newStream = stream.filter(x -> x > 50 );

          // System.out.println("After filter method new stream Elements: ");
          // newStream.forEach(ns -> System.out.println(ns)); // same string can't be used more than once for any operation

     }
}