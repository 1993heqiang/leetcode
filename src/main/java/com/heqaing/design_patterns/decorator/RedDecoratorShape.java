package com.heqaing.design_patterns.decorator;

import com.heqaing.design_patterns.factory.Shape;

public class RedDecoratorShape extends DecoratorShape {
    public RedDecoratorShape(Shape shape) {
        super(shape);
    }
    @Override
    public void draw(){
        shape.draw();
        setBorderColor();
    }
    private void setBorderColor(){
        System.out.println("Set Red Border!");
    }
}
