package com.heqaing.design_patterns.mvc;

public class StudentController {
    Student student;
    StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }
    public String getName(){
        return student.getName();
    }
    public void setName(String name){
        student.setName(name);
    }
    public String getRollNo(){
        return student.getRollNo();
    }
    public void setRollNo(String rollNo){
        student.setRollNo(rollNo);
    }
    public void updateView(){
        view.printStudentDeail(student.getName(),student.getRollNo());
    }
}
