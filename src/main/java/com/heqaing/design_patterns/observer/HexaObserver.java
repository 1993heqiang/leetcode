package com.heqaing.design_patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class HexaObserver implements Observer {
    Observable observable;

    public HexaObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Integer){
            System.out.println( "Hex String: "
                    + Integer.toHexString((Integer)arg).toUpperCase() );
        }
    }
}
