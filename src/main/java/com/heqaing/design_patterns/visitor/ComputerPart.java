package com.heqaing.design_patterns.visitor;

public interface ComputerPart  {
    void accept(ComputerPartVisitor computerPartVisitor);
}
