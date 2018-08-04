package com.heqaing.design_patterns.service_locator;

public class Service1 implements Service {
    @Override
    public void execute() {
        System.out.println("Execute Service1");
    }

    @Override
    public String getName() {
        return "Service1";
    }
}
