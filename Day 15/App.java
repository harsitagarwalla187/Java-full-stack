class Music extends Thread {
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("Playing music...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}

class Browser extends Thread {
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("User is browsing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

public class App {
    public static void main(String[] args) {

        Music m = new Music();
        Browser b = new Browser();
        m.start();
        b.start();

    }
}
