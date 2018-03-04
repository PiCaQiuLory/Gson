package com.qinker.gson;

import com.google.gson.Gson;
/**
 * 
 * Copyright (c)   2018 by lory
 * @ClassName:     GsonTester7.java
 * @Description:   静态内部类序列化/反序列化示例
 * 
 * @author:        lory
 * @version:       V1.0  
 * @Date:          2018年3月4日 下午1:33:46
 */
public class GsonTester7 {
	public static void main(String[] args) {
		Department d = new Department();
		d.setRollNo(20);
		Department.Name name = new Department.Name();
		name.firstName = "Max";
		name.lastName = "Su";
		d.setName(name);

		Gson gson = new Gson();
		String jsonString = gson.toJson(d);
		System.out.println(jsonString);
		d = gson.fromJson(jsonString, Department.class);

		System.out.println("Roll No: " + d.getRollNo());
		System.out.println("First Name: " + d.getName().firstName);
		System.out.println("Last Name: " + d.getName().lastName);
		String nameString = gson.toJson(name);
		System.out.println(nameString);

		name = gson.fromJson(nameString, Department.Name.class);
		System.out.println(name.getClass());
		System.out.println("First Name: " + name.firstName);
		System.out.println("Last Name: " + name.lastName);
	}
}

class Department {
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

	static class Name {
		public String firstName;
		public String lastName;
	}
}
