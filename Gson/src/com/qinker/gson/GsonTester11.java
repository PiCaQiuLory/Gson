package com.qinker.gson;

import java.lang.reflect.Modifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * 
 * Copyright (c) 2018 by lory
 * 
 * @ClassName: GsonTester11.java
 * @Description: Gson从序列化中排除字段:默认情况下，GSON排除序列化/反序列化过程中的瞬态和静态字段。 我们来看看下面的例子。
 * 
 * @author: lory
 * @version: V1.0
 * @Date: 2018年3月4日 下午2:40:56
 */
public class GsonTester11 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		Stduent11 student = new Stduent11();
		student.setRollNo(1);
		student.setName("Maxsu");
		student.setVerified(true);
		student.setId(1);
		student.className = "VI";

		String jsonString = gson.toJson(student);
		System.out.println(jsonString);// {"rollNo":1,"name":"Maxsu","verified":true}

		// GsonBuilder使用序列化/反序列化过程中的excludeFieldsWithModifiers()方法提供对使用特定修饰符排除字段的控制。
		// 看下面的例子。
		builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
		gson = builder.create();
		jsonString = gson.toJson(student);
		System.out.println(jsonString);//{"rollNo":1,"name":"Maxsu","verified":true,"className":"VI"}
		
		/*Gson提供@Expose注解来根据其范围控制类的Json序列化/反序列化。 考虑以下具有@Expose支持的变量的类。 在这个类中，
		name和rollno变量将被暴露以进行序列化。 然后，我们使用GsonBuilder.excludeFieldsWithoutExposeAnnotation()方法
		来指示只有暴露的变量要被序列化/反序列化。*/
		builder.excludeFieldsWithoutExposeAnnotation();
		gson = builder.create();

		jsonString = gson.toJson(student);
		System.out.println(jsonString);//{"rollNo":1,"name":"Maxsu","className":"VI"}
	}

}

class Stduent11 {

	@Expose
	private int rollNo;
	@Expose
	private String name;
	private boolean verified;
	private transient int id;
	@Expose
	public static String className;

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

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
