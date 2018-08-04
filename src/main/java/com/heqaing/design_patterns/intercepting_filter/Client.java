package com.heqaing.design_patterns.intercepting_filter;

public class Client {
    FilterManager manager;

    public Client(FilterManager manager) {
        this.manager = manager;
    }
    public void sendRequest(String request){
        manager.filterRequest(request);
    }
}
