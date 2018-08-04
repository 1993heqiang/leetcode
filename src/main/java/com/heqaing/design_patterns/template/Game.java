package com.heqaing.design_patterns.template;

public abstract class Game {
    protected abstract void startPlay();
    protected abstract void initialize();
    protected abstract void endPlay();

    public final void play(){
        startPlay();
        initialize();
        endPlay();
    }
}
