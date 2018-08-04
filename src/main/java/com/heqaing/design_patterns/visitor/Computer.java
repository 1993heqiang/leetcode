package com.heqaing.design_patterns.visitor;

public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[]{new Keyboard(),new Monitor(),new Mouse()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart part:parts){
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
