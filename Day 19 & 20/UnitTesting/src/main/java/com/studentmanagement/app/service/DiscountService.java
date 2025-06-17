package com.studentmanagement.app.service;

public class DiscountService {

    public double calculateDiscount(String type, double amount) {
        if(type.equals("PREMIUM")) {
            if(amount >= 1500) {
                return amount*0.1;
            } else {
                return 0d;
            }
        }

        return 0d;
    }
}
