package com.heqaing.design_patterns.singleton;

public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        return instance;
    }
    public void sayHi(){
        System.out.println("Hello World");
    }
    public static void main(String[] args){

    }
}
