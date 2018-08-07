package com.heqaing.design_patterns.singleton;

import java.util.concurrent.CountDownLatch;

public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public void sayHi() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        int threadNum = 100;
        CountDownLatch latch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                Singleton2.getInstance().sayHi();
                latch.countDown();
            }).run();
        }
        try {
            latch.await();
        } catch (Exception e) {
        }
    }
}
