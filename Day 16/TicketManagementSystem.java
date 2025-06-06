import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TicketPrinter {
    synchronized void print(String ticket) {
        System.out.println("Printed ticket: " + ticket);
    }
}

class TicketBooking implements Runnable {
    String user;

    TicketBooking(String user) {
        this.user = user;
    }

    public void run() {
        System.out.println(user + " ticket booked!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}

class TicketDetails implements Callable<String> {
    static int ticketId = 1000;
    String user;

    TicketDetails(String user) {
        this.user = user;
        ticketId++;
    }

    public String call() {
        String ticket = "Ticket is booked with ID " + ticketId + " " + user;
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println();
        }
        return ticket;
    }
}

class TicketManagementSystem {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(50);

        List<String> users = new ArrayList<>(Arrays.asList("Aman", "Amit", "Ankit", "Ramesh", "Sanju", "Harsit", "Harsh", "Gopal"));

//        for(String user:users) {
//            service.execute(new TicketBooking(user));
//        }

        for(String user:users) {
            service.execute(new TicketBooking(user));
            Future<String> f = service.submit(new TicketDetails(user));
            TicketPrinter t = new TicketPrinter();
            t.print(f.get());
        }

        service.shutdown();
    }
}