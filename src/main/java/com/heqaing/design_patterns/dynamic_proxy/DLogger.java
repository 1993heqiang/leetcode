package com.heqaing.design_patterns.dynamic_proxy;

import java.lang.reflect.Method;

public class DLogger implements ILogger {
    @Override
    public void start(Method method) {
        System.out.println("Log " + method.getName() + "执行前");
    }

    @Override
    public void end(Method method) {
        System.out.println("Log " + method.getName() + "执行后");
    }
}
