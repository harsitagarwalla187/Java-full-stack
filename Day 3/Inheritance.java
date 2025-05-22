class vehicle {
     void start() {
          System.out.println("Vehicle is starting...");
     }
}

class Car extends vehicle {
     void drive() {
          System.out.println("Car is Driving...");
     }
}

class Bike extends vehicle {
     void changeGear() {
          System.out.println("Gear is changed!.");
     }
}

public class Inheritance {
     public static void main(String[] args) {
          Car c = new Car();
          c.start();
          c.drive();

          Bike b = new Bike();
          b.start();
          b.changeGear();
     }
}
