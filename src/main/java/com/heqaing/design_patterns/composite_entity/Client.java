package com.heqaing.design_patterns.composite_entity;

public class Client {
    CoarseGrainedObject cgo = new CoarseGrainedObject();
    public void setData(String data1,String data2){
        cgo.setData(data1,data2);
    }
    public void  print(){
        String[] datas = cgo.getData();
        for(String data:datas){
            System.out.println(data);
        }
    }
}
