// Example 1
// import java.util.Queue;
// import java.util.LinkedList;

// public class Main1 {
//     public static void main(String[] args) {

//         Queue<String> queue =  new LinkedList<>();

//         queue.add("Amit");
//         queue.add("Neha");
//         queue.add("Ramesh");

//         System.out.println("Queue: " + queue );
//         System.out.println("Serving: " + queue.poll());
//         System.out.println("Next: " + queue.peek());
//         System.out.println("Remaining: " + queue );

//     }
// }

// Example 2
// import java.util.PriorityQueue;

// public class Main1 {
//     public static void main(String[] args) {
//         PriorityQueue<Integer> queue = new PriorityQueue<>();

//         queue.add(3);
//         queue.add(1);
//         queue.add(2);
//         queue.add(5);
//         queue.add(0);


//         System.out.println("Order of number: " + queue);
//         System.out.println("Priority: " + queue.poll());
//         System.out.println("Order of number: " + queue);


//         System.out.println("Order of number: ");
//         while(!queue.isEmpty()) {
//             System.out.println("Priority: " + queue.poll());
//         }
//     }
// }

