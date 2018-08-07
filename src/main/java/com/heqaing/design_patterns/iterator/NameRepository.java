package com.heqaing.design_patterns.iterator;

public class NameRepository implements Container {
    private String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            if(hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
