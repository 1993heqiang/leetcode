package com.heqaing.design_patterns.observer;

import java.util.Observable;

public class Subject extends Observable {

    private Integer state;

    public Subject() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        setChanged();
        notifyObservers(state);
    }
}
