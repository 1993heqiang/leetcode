package com.heqaing.design_patterns.intercepting_filter;

public class FilterManager {
    FilterChain chain;

    public FilterManager(Target target) {
        chain = new FilterChain();
        chain.setTarget(target);
    }
    public void setFilter(Filter filter){
        chain.addFilter(filter);
    }
    public void filterRequest(String request){
        chain.execute(request);
    }
}
