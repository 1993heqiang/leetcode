package com.heqaing.design_patterns.factory;

public class ShapeFactory {
    public static Shape getShape(String shapeType){
        Shape shape;
        if("circle".equalsIgnoreCase(shapeType)){
            shape = new Circle();
        }else if("square".equalsIgnoreCase(shapeType)){
            shape = new Square();
        }else if("rectangle".equalsIgnoreCase(shapeType)){
            shape = new Rectangle();
        }else {
            shape = ()-> {
                System.out.println("shape do not exist");
            };
        }
        return shape;
    }
}
