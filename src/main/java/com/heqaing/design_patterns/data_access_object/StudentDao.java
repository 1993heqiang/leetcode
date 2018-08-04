package com.heqaing.design_patterns.data_access_object;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(String id);
    void add(Student student);
    void update(Student student);
    void deleteById(String id);
}
