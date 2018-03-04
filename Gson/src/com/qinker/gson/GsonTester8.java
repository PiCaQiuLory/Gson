package com.qinker.gson;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Copyright (c) 2018 by lory
 * 
 * @ClassName: GsonTester8.java
 * @Description: Gson自定义适配器示例
 * 
 * @author: lory
 * @version: V1.0
 * @Date: 2018年3月4日 下午1:34:48
 */
public class GsonTester8 {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Student8.class, new StudentAdapter());
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String jsonString = "{\"name\":\"Maxsu\", \"rollNo\":1}";
		Student8 student = gson.fromJson(jsonString, Student8.class);
		System.out.println(student);

		jsonString = gson.toJson(student);
		System.out.println(jsonString);
	}
}

class StudentAdapter extends TypeAdapter<Student8> {

	@Override
	public void write(JsonWriter writer, Student8 student) throws IOException {
		writer.beginObject();
		writer.name("name");
		writer.value(student.getName());
		writer.name("rollNo");
		writer.value(student.getRollNo());
		writer.endObject();
	}

	@Override
	public Student8 read(JsonReader reader) throws IOException {
		Student8 student = new Student8();
		reader.beginObject();
		String fieldname = null;

		while (reader.hasNext()) {
			JsonToken token = reader.peek();

			if (token.equals(JsonToken.NAME)) {
				// get the current token
				fieldname = reader.nextName();
			}
			if ("name".equals(fieldname)) {
				// move to next token
				token = reader.peek();
				student.setName(reader.nextString());
			}
			if ("rollNo".equals(fieldname)) {
				// move to next token
				token = reader.peek();
				student.setRollNo(reader.nextInt());
			}
		}
		reader.endObject();
		return student;
	}

}

class Student8 {
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
