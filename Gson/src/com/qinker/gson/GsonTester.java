package com.qinker.gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * Copyright (c)   2018 by lory
 * @ClassName:     GsonTester.java
 * @Description:   将Java对象序列化到文件当中，在从json文件序列化Java对象
 * 
 * @author:        lory
 * @version:       V1.0  
 * @Date:          2018年3月4日 上午11:06:38
 */
public class GsonTester {

	public static void main(String[] args) {
		GsonTester tester = new GsonTester();
		Student student = new Student();
		student.setName("kevin");
		student.setAge(1222);
		try {
			tester.writeJSON(student);
			Student student1 = tester.readJSON();
			System.out.println(student1.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeJSON(Student student) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		FileWriter writer = new FileWriter("student.json");
		writer.write(gson.toJson(student));
		writer.close();
	}

	private Student readJSON() throws FileNotFoundException {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		BufferedReader reader = new BufferedReader(new FileReader("student.json"));
		Student student = gson.fromJson(reader, Student.class);
		return student;
	}

}

class Student {
	private String name;
	private int age;

	public Student() {
	}

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

	public String toString() {
		return "Student [ name: " + name + ", age: " + age + " ]";
	}
}
