package com.heqaing.design_patterns.intercepting_filter;

public class Target {
    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}
