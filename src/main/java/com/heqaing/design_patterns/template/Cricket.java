package com.heqaing.design_patterns.template;

public class Cricket extends Game {
    @Override
    protected void startPlay() {
        System.out.println("start " + this.getClass().getSimpleName());
    }

    @Override
    protected void initialize() {
        System.out.println("initialize " + this.getClass().getSimpleName());
    }

    @Override
    protected void endPlay() {
        System.out.println("end " + this.getClass().getSimpleName());
    }
}
