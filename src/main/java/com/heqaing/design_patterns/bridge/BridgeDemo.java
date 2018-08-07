package com.heqaing.design_patterns.bridge;

public class BridgeDemo {
    public static void main(String[] args){
        Circle c1 = new Circle(2,3,4,new RedCircle());
        Circle c2 = new Circle(2,3,4,new GreenCircle());
        c1.draw();
        c2.draw();
    }
}
