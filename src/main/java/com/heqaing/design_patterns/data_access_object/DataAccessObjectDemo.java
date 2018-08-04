package com.heqaing.design_patterns.data_access_object;

public class DataAccessObjectDemo {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        dao.findAll().stream().forEach(e -> print(e));
        System.out.println("------------------------------------------");
        Student s3 = new Student();
        s3.setName("meixi");
        s3.setId("3");
        s3.setAge(30);
        dao.add(s3);
        dao.findAll().stream().forEach(e -> print(e));
        System.out.println("------------------------------------------");
        Student s2 = dao.findById("2");
        s2.setAge(40);
        dao.update(s2);
        dao.findAll().stream().forEach(e -> print(e));
        System.out.println("------------------------------------------");
        dao.deleteById("1");
        dao.findAll().stream().forEach(e -> print(e));

    }

    public static void print(Student student) {
        System.out.println("id:" + student.getId() + ",name:" + student.getName() + ",age:" + student.getAge());
    }
}
