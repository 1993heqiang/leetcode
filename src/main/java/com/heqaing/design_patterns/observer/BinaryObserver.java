package com.heqaing.design_patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class BinaryObserver implements Observer {
    Observable observable;

    public BinaryObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Binary String: "
                    + Integer.toBinaryString((Integer) arg).toUpperCase());
        }
    }
}
