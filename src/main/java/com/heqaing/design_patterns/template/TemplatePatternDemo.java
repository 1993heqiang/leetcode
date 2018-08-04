package com.heqaing.design_patterns.template;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Football football = new Football();
        football.play();
        Game cricket = new Cricket();
        cricket.play();
    }
}
