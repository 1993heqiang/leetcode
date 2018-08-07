package com.heqaing.design_patterns.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = iter.next();
            System.out.println("Name : " + name);
        }
    }
}
