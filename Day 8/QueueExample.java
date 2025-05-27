import java.util.ArrayDeque;

public class QueueExample {
     public static void main(String[] args) {
          ArrayDeque<String> q = new ArrayDeque<>();

          q.addFirst("Type A");
          q.addFirst("Type B");
          q.addFirst("Delete Line");
          q.addFirst("Paste Line");

          System.out.println("Undo: " + q.removeFirst());
          System.out.println("Undo: " + q.removeFirst());

          System.out.println("Remaining Action: " + q);

     }
}