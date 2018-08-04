package com.heqaing.design_patterns.service_locator;

public class ServiceLocator {
    private static Cache cache;
    static {
        cache = new Cache();
    }
    public Service getService(String serviceName){
        Service service = cache.getService(serviceName);
        if(service==null){
            InitialContext context = new InitialContext();
            service = context.lookup(serviceName);
            if(service!=null){
                cache.addService(service);
            }
        }
        return service;
    }
}
