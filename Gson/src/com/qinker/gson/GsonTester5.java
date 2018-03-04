package com.qinker.gson;

import java.util.Arrays;

import com.google.gson.Gson;

/**
 * 
 * Copyright (c) 2018 by lory
 * 
 * @ClassName: GsonTester5.java
 * @Description: 数组的序列化与反序列化
 * 
 * @author: lory
 * @version: V1.0
 * @Date: 2018年3月4日 下午1:14:53
 */
public class GsonTester5 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		int[] marks = { 100, 90, 85 };
		String[] names = { "Maxsu", "Yiibai", "Mohan" };
		
		System.out.println("{");
		System.out.println("marks:"+gson.toJson(marks)+",");
		System.out.println("names:"+gson.toJson(names));
		System.out.println("}");
		
		marks = gson.fromJson("[40,63,6456]", int[].class);
		names = gson.fromJson("[\"Maxsu\",\"Yiibai\",\"Mohan\"]", String[].class);
		
		System.out.println("marks:"+Arrays.toString(marks));
		System.out.println("names:"+Arrays.toString(names));
		
	}

}
