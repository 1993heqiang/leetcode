package com.heqaing.design_patterns.business_delegate;

public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType){
        BusinessService service;
        if("EJB".equalsIgnoreCase(serviceType)){
            service = new EJBService();
        }else {
            service = new JMSService();
        }
        return service;
    }
}
