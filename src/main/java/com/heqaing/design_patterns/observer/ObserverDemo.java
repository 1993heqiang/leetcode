package com.heqaing.design_patterns.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new HexaObserver(subject);
        subject.setState(0);
        subject.setState(10000);
    }

}
