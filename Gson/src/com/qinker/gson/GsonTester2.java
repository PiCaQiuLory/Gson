package com.qinker.gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
/**
 * 
 * Copyright (c)   2018 by lory
 * @ClassName:     GsonTester2.java
 * @Description:   将集合类型的Java对象序列化为json文件，在将json文件序列化为List Java对象
 * 
 * @author:        lory
 * @version:       V1.0  
 * @Date:          2018年3月4日 上午11:36:11
 */
public class GsonTester2 {
	public static void main(String[] args) throws IOException {
		ArrayList<Student2> list = new ArrayList<>();
		Student2 student1 = new Student2();
		student1.setName("kevin");
		student1.setAge(1222);
		Student2 student2 = new Student2();
		student2.setName("kevin");
		student2.setAge(1222);
		Student2 student3 = new Student2();
		student3.setName("kevin");
		student3.setAge(1222);
		Student2 student4 = new Student2();
		student4.setName("kevin");
		student4.setAge(1222);
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String json = gson.toJson(list);
		FileWriter writer = new FileWriter("list.json");
		writer.write(json);
		writer.close();
		FileReader reader = new FileReader("list.json");
		//对象序列化令牌设置
		Type type = new TypeToken<List<Student2>>() {}.getType();
		ArrayList<Student2> fromJson = gson.fromJson(reader, type);
		for(Student2 stu : fromJson) {
			System.out.println(stu.getName());
		}
		
	}
}
class Student2 {
	private String name;
	private int age;

	public Student2() {
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

