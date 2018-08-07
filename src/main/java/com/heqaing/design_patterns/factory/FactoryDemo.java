package com.heqaing.design_patterns.factory;

public class FactoryDemo {
    public static void main(String[] args){
        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();
        shape = ShapeFactory.getShape("square");
        shape.draw();
        shape = ShapeFactory.getShape("rectangle");
        shape.draw();
        shape = ShapeFactory.getShape("others");
        shape.draw();
    }
}
