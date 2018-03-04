package com.qinker.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 
 * Copyright (c)   2018 by lory
 * @ClassName:     GsonFirstApp.java
 * @Description:   Gson入门，将对象序列化成json串，再将json串反序列化为Java对象 
 * 
 * @author:        lory
 * @version:       V1.0  
 * @Date:          2018年3月4日 上午11:37:07
 */
public class GsonFirstApp {

	public static void main(String[] args) {
		String jsonString = "{\"name\":\"lory\",\"age\":52}";
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		// 将json反序列化为对象
		Student student = gson.fromJson(jsonString, Student.class);
		System.out.println(student.getName());
		
		String jsonStr = gson.toJson(student);
		System.out.println(jsonStr);
	}

	class Student {
		private String name;

		private int age;

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

	}
}
