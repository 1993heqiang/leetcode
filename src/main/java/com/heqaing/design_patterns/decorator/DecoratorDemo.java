package com.heqaing.design_patterns.decorator;

import com.heqaing.design_patterns.factory.Circle;

public class DecoratorDemo {
    public static void main(String[] args){
        Circle circle = new Circle();
        RedDecoratorShape decoratorShape = new RedDecoratorShape(circle);
        decoratorShape.draw();

    }
}
