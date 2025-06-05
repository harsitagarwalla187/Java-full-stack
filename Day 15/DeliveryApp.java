class Food extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("Food is being prepared!");
            Thread.sleep(3000);
            System.out.println("Food is ready!");
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}

class Delivery extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("Delivery boy is on the way!");
            Thread.sleep(4000);
            System.out.println("Delivery is done!");
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}

public class DeliveryApp {
    public static void main(String[] args) throws InterruptedException {

        Food f = new Food();
        Delivery d = new Delivery();

        f.start();
        f.join();

        d.start();
        d.join();

        System.out.println("Order delivered!");
    }
}
