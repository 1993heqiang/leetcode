package com.heqaing.design_patterns.facade;

import com.heqaing.design_patterns.factory.Circle;
import com.heqaing.design_patterns.factory.Rectangle;
import com.heqaing.design_patterns.factory.Square;

public class FacadeDemo {
    public static void main(String[] args){
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        ShapeMaker maker = new ShapeMaker(circle,square,rectangle);
        maker.drawCircle();
        maker.drawSquare();
        maker.drawRectangle();
    }
}
