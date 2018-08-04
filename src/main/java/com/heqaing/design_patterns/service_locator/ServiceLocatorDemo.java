package com.heqaing.design_patterns.service_locator;

public class ServiceLocatorDemo {
    public static void main(String[] args){
        ServiceLocator serviceLocator = new ServiceLocator();
        Service service = serviceLocator.getService("Service1");
        service.execute();
        service = serviceLocator.getService("Service2");
        service.execute();
        service = serviceLocator.getService("Service3");
        System.out.println(service);
    }
}
