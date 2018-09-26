package com.heqaing.design_patterns.dynamic_proxy;

import com.heqaing.design_patterns.proxy.Hello;
import com.heqaing.design_patterns.proxy.IHello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置方法");
        Object result = method.invoke(target, args);
        System.out.println("后置方法");
        return result;
    }
    public static void main(String[] args){
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello("test");
    }
}
