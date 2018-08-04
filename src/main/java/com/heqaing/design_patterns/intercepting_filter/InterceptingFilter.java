package com.heqaing.design_patterns.intercepting_filter;

public class InterceptingFilter {
    public static void main(String[] args){
        FilterManager manager = new FilterManager(new Target());
        manager.setFilter(new DebugFilter());
        manager.setFilter(new AuthenticationFilter());
        Client client = new Client(manager);
        client.sendRequest("test");
        client.sendRequest("hello_world");
    }
}
