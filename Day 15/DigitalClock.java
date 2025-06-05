import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Clock implements Runnable {

    public void run() {
        try {
            while(true) {
                System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {}
    }
}

public class DigitalClock {
    public static void main(String[] args) {

        Thread t = new Thread(new Clock());
        t.start();

    }
}
