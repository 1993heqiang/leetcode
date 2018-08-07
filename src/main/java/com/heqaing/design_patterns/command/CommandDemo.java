package com.heqaing.design_patterns.command;

public class CommandDemo {
    public static void main(String[] args){
        Stock stock = new Stock("牛肉面",10);
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);
        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        broker.placeOrders();
    }
}
