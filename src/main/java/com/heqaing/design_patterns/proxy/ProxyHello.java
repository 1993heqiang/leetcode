package com.heqaing.design_patterns.proxy;

public class ProxyHello implements IHello {

    private IHello target;

    public ProxyHello(IHello target) {
        this.target = target;
    }

    @Override
    public void sayHello(String str) {
        System.out.println("前置动作");
        target.sayHello(str);
        System.out.println("后置动作");
    }
    public static void main(String[] args){
        IHello hello = new ProxyHello(new Hello());
        hello.sayHello("test");
    }
}
