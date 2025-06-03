import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    static int id = 0;
    private String customerName, foodItem;
    private int quantity;
    private LocalDate orderDate;
    private transient int orderId;

    Order() {
        id++;
    }

    void addOrder(String name, String item, int qty) {
        this.customerName = name;
        this.foodItem = item;
        this.quantity = qty;
        orderId = id;
        orderDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Customer Name: " + customerName + ", Food Item: " + foodItem + ", Quantity: " + quantity + ", Order Date: " + orderDate;
    }
}
