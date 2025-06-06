class Printer {
    synchronized void print(String employeeName) {
            System.out.println("Printing " + employeeName + "'s documents...");
            try {
                Thread.sleep(3000);
            } catch(InterruptedException e) {}
    }
}

class Employee extends Thread {
    private String name;
    Printer printer;

    Employee(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    public void run() {
        printer.print(name);
    }
}

public class OfficePrinter {
    public static void main(String[] args) {

        Printer p = new Printer();
        Employee e1 = new Employee("Harsit", p);
        Employee e2 = new Employee("Harsh", p);

        e1.start();
        e2.start();
    }
}
