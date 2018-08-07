package com.heqaing.design_patterns.prototype;

public class PrototypeDemo {
    public static void main(String[] args){
        ShapeCache.loadCache();
        Shape circle = ShapeCache.getShape("1");
        System.out.println(circle.getType());
        Shape square = ShapeCache.getShape("2");
        System.out.println(square.getType());
        Shape rectangle = ShapeCache.getShape("3");
        System.out.println(rectangle.getType());
    }
}
