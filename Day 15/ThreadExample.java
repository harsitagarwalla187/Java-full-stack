class A implements Runnable {
    public void run() {
        for(int i=1; i<=10; i++) {
            System.out.println("Thread A: " + i);
        }
    }
}

class B implements Runnable {
    public void run() {
        for(int i=1; i<=10; i++) {
            System.out.println("Thread B: " + i);
        }
    }
}

class C extends Thread {
    public void run() {
        for(int i=1; i<=10; i++) {
            System.out.println("Thread C: " + i);
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {

        A a = new A();
        B b = new B();
        C c = new C();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start();
        t2.start();
        c.start();
    }
}
