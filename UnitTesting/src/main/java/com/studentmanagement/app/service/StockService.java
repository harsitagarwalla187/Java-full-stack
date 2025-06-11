package com.studentmanagement.app.service;

public class StockService {
    private int stock;

    public StockService(int stock) {
        this.stock = stock;
    }

    public void updateStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}
