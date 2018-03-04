package com.qinker.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * Copyright (c) 2018 by lory
 * 
 * @ClassName: GsonTester9.java
 * @Description: Gson的空对象支持:Gson默认生成优化的Json内容，忽略NULL值。 
 * 但是GsonBuilder提供的标志使用GsonBuilder.serializeNulls()方法在Json输出中显示NULL值。
 * 
 * @author: lory
 * @version: V1.0
 * @Date: 2018年3月4日 下午1:41:08
 */
public class GsonTester9 {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		Student9 student = new Student9();
		student.setRollNo(1);
		String jsonString = gson.toJson(student);

		System.out.println(jsonString);
		student = gson.fromJson(jsonString, Student9.class);
		System.out.println(student);
	}
}

class Student9 {
	private int rollNo;
	private String name;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Student[ name = " + name + ", roll no: " + rollNo + "]";
	}
}
