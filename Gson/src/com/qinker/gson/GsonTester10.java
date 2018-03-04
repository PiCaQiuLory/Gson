package com.qinker.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;

/**
 * 
 * Copyright (c) 2018 by lory
 * 
 * @ClassName: GsonTester10.java
 * @Description: Gson版本支持，Gson提供了@Since注解来控制基于其各种版本的类的Json序列化/反序列化。
 * 
 * @author: lory
 * @version: V1.0
 * @Date: 2018年3月4日 下午2:35:15
 */
public class GsonTester10 {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.setVersion(1.0);
		Gson gson = builder.create();

		Student10 student = new Student10();
		student.setName("Maxsu");
		student.setAge(20);
		student.setGrade("一年级");

		String jsonString = gson.toJson(student);
		System.out.println(jsonString);

		gson = new Gson();
		jsonString = gson.toJson(student);
		System.out.println(jsonString);
	}
}

class Student10 {
	@Since(value = 1.0)
	private String name;

	@Since(1.0)
	private int age;

	@Since(1.2)
	private String grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}