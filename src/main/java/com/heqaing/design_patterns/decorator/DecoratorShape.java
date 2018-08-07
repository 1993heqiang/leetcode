package com.heqaing.design_patterns.decorator;

import com.heqaing.design_patterns.factory.Shape;

public abstract class DecoratorShape implements Shape {
    protected Shape shape;
    public DecoratorShape(Shape shape){
        this.shape = shape;
    }
    public void draw(){
        shape.draw();
    }
}
