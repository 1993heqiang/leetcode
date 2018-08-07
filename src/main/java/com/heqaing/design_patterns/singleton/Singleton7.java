package com.heqaing.design_patterns.singleton;

public enum  Singleton7 {
    INSTANCE;
    public void sayHi(){
        System.out.println("Hello World");
    }
    public static void main(String[] args){
        Singleton7.INSTANCE.sayHi();
    }
}
