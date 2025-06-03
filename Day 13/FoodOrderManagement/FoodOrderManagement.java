import java.io.*;
import java.util.Scanner;

public class FoodOrderManagement {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        File file = new File("orders.bin");
        FileOutputStream fos = new FileOutputStream(file, true);
        boolean append = file.exists() && (file.length() > 0);
        ObjectOutputStream oos = append ?   new SerialConfig(fos) : new ObjectOutputStream(fos);

        boolean flag = true;
        while(flag) {
            System.out.println("Select: ");
            System.out.println("1. Place an Order.");
            System.out.println("2. Show all Orders.");
            System.out.println("3. Exit");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1: System.out.println("Give your order:");
                        System.out.println("Your Name:");
                        String name = scan.nextLine();
                        System.out.println("Your Food Item:");
                        String item = scan.nextLine();
                        System.out.println("Your Quantity:");
                        int qty = scan.nextInt();
                        Order o = new Order();
                        o.addOrder(name, item, qty);
                        oos.writeObject(o);
                    break;
                case 2: try {
                            System.out.println("All order : ");
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orders.bin"));
                            while(true) {
                                System.out.println(ois.readObject());
                            }
                    } catch(EOFException e) {
                        System.out.println("*** END ***");
                    }
                    break;
                default: flag = false;
            }
        }

    }
}
