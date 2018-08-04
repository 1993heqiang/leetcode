package com.heqaing.design_patterns.front_controller;

public class Dispatcher {
    HomeView homeView;
    StudentView studentView;

    public Dispatcher() {
        homeView = new HomeView();
        studentView = new StudentView();
    }

    public void dispatcher(String viewType){
        if("Home".equalsIgnoreCase(viewType)){
            homeView.show();
        }else {
            studentView.show();
        }
    }
}
