package com.heqaing.design_patterns.data_access_object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    Map<String,Student> studentMap;

    public StudentDaoImpl() {
        studentMap = new HashMap<>();
        Student s1 = new Student();
        s1.setName("heqiang");
        s1.setId("1");
        s1.setAge(25);
        Student s2 = new Student();
        s2.setName("lilei");
        s2.setId("2");
        s2.setAge(21);
        studentMap.put(s1.getId(),s1);
        studentMap.put(s2.getId(),s2);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        students.addAll(studentMap.values());
        return students;
    }

    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }

    @Override
    public void add(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void update(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }
}
