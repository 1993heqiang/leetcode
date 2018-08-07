package com.heqaing.design_patterns.singleton;

public class Singleton6 {
    private static class SingletonHolder{
        private static final Singleton6 INSTANCE = new Singleton6();
    }
    private Singleton6(){

    }
    public static final Singleton6 getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public void sayHi(){
        System.out.println("Hello World");
    }
    public static void main(String[] args){
        Singleton6.getInstance().sayHi();
    }
}
