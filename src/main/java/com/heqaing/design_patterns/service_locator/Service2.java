package com.heqaing.design_patterns.service_locator;

public class Service2 implements Service {
    @Override
    public void execute() {
        System.out.println("Execute Service2");
    }

    @Override
    public String getName() {
        return "Service2";
    }
}
