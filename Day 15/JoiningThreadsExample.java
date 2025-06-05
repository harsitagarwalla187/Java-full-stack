class Task1 extends Thread {
    public void run() {
        System.out.println("Document scan...");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {}
        System.out.println("Scan completed.");
    }
}

class Task2 extends Thread {
    public void run() {
        System.out.println("Photo uploading...");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
        System.out.println("Upload completed.");
    }
}

public class JoiningThreadsExample {
    public static void main(String[] args) throws InterruptedException {

        Task1 t1 = new Task1();
        Task2 t2 = new Task2();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Form submitted.");
        System.out.println("Form submitted successfully.");
    }
}