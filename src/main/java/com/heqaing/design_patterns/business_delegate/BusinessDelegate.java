package com.heqaing.design_patterns.business_delegate;

public class BusinessDelegate {
    BusinessLookUp businessLookUp = new BusinessLookUp();
    BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService =  businessLookUp.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
