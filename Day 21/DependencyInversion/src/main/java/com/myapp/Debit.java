package com.myapp;

class Debit implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Debit Card.");
    }
}
