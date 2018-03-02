package com.heqaing.test;

public class Test_clazz {

	public static void main(String[] args) throws Exception{
		Employee e1 = new Employee("test",12);
		Employee e2 = e1;
		e1.setAge(10);
		e1 = null;
		System.out.println(e1);
		System.out.println(e2);


	}

}
