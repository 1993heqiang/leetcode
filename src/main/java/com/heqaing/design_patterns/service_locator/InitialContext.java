package com.heqaing.design_patterns.service_locator;

public class InitialContext {
    public Service lookup(String serviceName){
        Service service = null;
        if("Service1".equalsIgnoreCase(serviceName)){
            service = new Service1();
        }else if ("Service2".equalsIgnoreCase(serviceName)){
            service = new Service2();
        }
        return service;
    }
}
