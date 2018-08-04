package com.heqaing.design_patterns.business_delegate;

public class JMSService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("JMS Service do processing!");
    }
}
