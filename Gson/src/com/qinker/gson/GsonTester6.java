package com.qinker.gson;

import com.google.gson.Gson;

/**
 * 
 * Copyright (c) 2018 by lory
 * 
 * @ClassName: GsonTester6.java
 * @Description: Gson序列化/反序列化内部类
 * 
 * @author: lory
 * @version: V1.0
 * @Date: 2018年3月4日 下午1:22:26
 */
public class GsonTester6 {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setRollNo(10);
		Employee.Name name = e.new Name();
		name.firstName = "lory";
		name.lastName = "li";
		e.setName(name);
		Gson gson = new Gson();
		String jsonE = gson.toJson(e);
		System.out.println(jsonE);
		
		e = gson.fromJson(jsonE, Employee.class);
		System.out.println(e.getName().firstName);
		System.out.println(e.getName().lastName);
		System.out.println(e.getRollNo());
		
		String nameStr = gson.toJson(name);
		System.out.println(nameStr);
		
		name = gson.fromJson(nameStr, Employee.Name.class);
		System.out.println(name.getClass());
		System.out.println(name.firstName);
		System.out.println(name.lastName);
		
	}
}

class Employee {
	private int rollNo;
	private Name name;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	class Name {
		public String firstName;
		public String lastName;
	}
}
