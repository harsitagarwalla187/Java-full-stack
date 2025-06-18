package com.myapp;

class OrderService {
    private Payment paymentMethod;

    public OrderService() {}

    public OrderService(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void placeOrder(double amount) {
        System.out.println("Placing order...");
        paymentMethod.pay(amount);
        System.out.println("Order placed successfully.\n");
    }
}