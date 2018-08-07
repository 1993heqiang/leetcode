package com.heqaing.design_patterns.facade;

import com.heqaing.design_patterns.factory.Circle;
import com.heqaing.design_patterns.factory.Rectangle;
import com.heqaing.design_patterns.factory.Square;

public class ShapeMaker {
    private Circle circle;
    private Square square;
    private Rectangle rectangle;

    public ShapeMaker(Circle circle, Square square, Rectangle rectangle) {
        this.circle = circle;
        this.square = square;
        this.rectangle = rectangle;
    }
    public void drawCircle(){
        circle.draw();
    }
    public void drawSquare(){
        square.draw();;
    }
    public void drawRectangle(){
        rectangle.draw();
    }

}
