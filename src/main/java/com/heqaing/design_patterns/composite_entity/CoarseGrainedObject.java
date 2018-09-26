package com.heqaing.design_patterns.composite_entity;

public class CoarseGrainedObject {
    public DependentObject1 do1 = new DependentObject1();
    public DependentObject2 do2 = new DependentObject2();

    public void setData(String data1,String data2){
        do1.setData(data1);
        do2.setData(data2);
    }

    public String[] getData(){
        return new String[]{do1.getData(),do2.getData()};
    }
}