package com.heqaing.design_patterns.command;

public class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void sell() {
        System.out.println("sell " + name + " , " + quantity);
    }

    public void buy() {
        System.out.println("buy " + name + " , " + quantity);
    }
}
