package com.heqaing.design_patterns.dynamic_proxy;

import com.heqaing.design_patterns.proxy.Hello;
import com.heqaing.design_patterns.proxy.IHello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy2 implements InvocationHandler {
    private Object target;
    private Object proxy;

    public Object bind(Object target, Object proxy) {
        this.target = target;
        this.proxy = proxy;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class proxyClazz = this.proxy.getClass();
        Method start = proxyClazz.getDeclaredMethod("start", Method.class);
        start.invoke(this.proxy, method);
        Object result = method.invoke(target, args);
        Method end = proxyClazz.getDeclaredMethod("end", Method.class);
        end.invoke(this.proxy, method);
        return result;
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy2().bind(new Hello(), new DLogger());
        hello.sayHello("test");
    }
}
