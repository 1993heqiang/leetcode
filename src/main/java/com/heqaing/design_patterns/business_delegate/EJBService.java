package com.heqaing.design_patterns.business_delegate;

public class EJBService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("EJB Service do processing!");
    }
}
