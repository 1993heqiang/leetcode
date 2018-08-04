package com.heqaing.design_patterns.mvc;

public class MVCPatternDemo {
    public static void main(String[] args){
        Student student = new Student();
        student.setName("heqiang");
        student.setRollNo("001");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student,view);
        controller.updateView();
        controller.setName("wangwu");
        controller.setRollNo("004");
        controller.updateView();
    }
}
