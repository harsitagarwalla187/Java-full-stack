class MovieScreen implements Runnable {

    private String movieName;

    MovieScreen(String movieName) {
        this.movieName = movieName;
    }

    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(movieName + " is now Streaming.");
            try {
                Thread.sleep((int)(Math.random() * 5000) + 1);
            } catch (InterruptedException e) {}
        }
    }
}

public class Theater {
    public static void main(String[] args) {

        MovieScreen ms1 = new MovieScreen("IPL");
        MovieScreen ms2 = new MovieScreen("Criminal Justice");
        MovieScreen ms3 = new MovieScreen("Do or Die");

        Thread t1 = new Thread(ms1);
        Thread t2 = new Thread(ms2);
        Thread t3 = new Thread(ms3);

        t1.start();
        t2.start();
        t3.start();

    }
}
