package com.heqaing.design_patterns.composite_entity;

public class CompositeEntityDemo {
    public static void main(String[] args) {
        Client client = new Client();
        client.setData("obj1", "obj2");
        client.print();
        client.setData("haha","hehe");
        client.print();
    }
}
