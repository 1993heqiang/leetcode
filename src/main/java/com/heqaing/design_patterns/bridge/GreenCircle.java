package com.heqaing.design_patterns.bridge;

public class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Draw Green Circle,radius="+radius+",x="+x+",y="+y);
    }
}
