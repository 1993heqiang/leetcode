package com.heqaing.design_patterns.front_controller;

public class FrontControllerDemo {
    public static void main(String[] args){
        FrontController controller = new FrontController();
        controller.dispatchRequest("Home");
        controller.dispatchRequest("Student");
    }
}
