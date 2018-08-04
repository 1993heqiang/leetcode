package com.heqaing.design_patterns.service_locator;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    Map<String,Service> serviceMap;

    public Cache() {
        serviceMap = new HashMap<>();
    }
    public Service getService(String serviceName){
        return serviceMap.get(serviceName);
    }
    public void addService(Service service){
        serviceMap.put(service.getName(),service);
    }
}
