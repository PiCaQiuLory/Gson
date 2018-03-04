package com.qinker.gson;

import java.io.IOException;
import java.io.StringReader;


import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
/**
 * 
 * Copyright (c)   2018 by lory
 * @ClassName:     GsonTester4.java
 * @Description:   Streaming API用于通过令牌读取JSON令牌。 它读取和写入JSON内容作为离散事件。 
 * JsonReader和JsonWriter将数据读取/写入令牌，称为JsonToken。这是处理JSON的三种方法中最强大的方法。
 *  它具有最低的开销，并且在读/写操作中速度非常快。 它类似于用于XML的Stax解析器。 
 * 
 * @author:        lory
 * @version:       V1.0  
 * @Date:          2018年3月4日 下午1:11:10
 */
public class GsonTester4 {

	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Maxsu\", \"age\":26,\"verified\":false,\"marks\": [100,90,85]}";
		JsonReader reader = new JsonReader(new StringReader(jsonString));
		try {
			handleJsonObject(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void handleJsonObject(JsonReader reader) throws IOException {
		reader.beginObject();
		String filename = null;

		while (reader.hasNext()) {
			JsonToken token = reader.peek();
			if (token.equals(JsonToken.BEGIN_ARRAY)) {
				System.out.print("Marks [ ");
				handlerArray(reader);
				System.out.print("]");
			} else if (token.equals(JsonToken.END_OBJECT)) {
				reader.endObject();
				return;
			} else {
				if (token.equals(JsonToken.NAME)) {
					//get the current token 
					filename = reader.nextName();
				}
				if ("name".equals(filename)) {
					// move to next token
					token = reader.peek();
					System.out.println("name:" + reader.nextString());
				}
				if ("age".equals(filename)) {
					token = reader.peek();
					System.out.println("age:" + reader.nextInt());
				}
				if ("verified".equals(filename)) {
					token = reader.peek();
					System.out.println("verified:" + (reader.nextBoolean() ? "YES" : "NO"));
				}
			}
		}
	}

	private static void handlerArray(JsonReader reader) throws IOException {
		reader.beginArray();

		while (true) {
			JsonToken token = reader.peek();

			if (token.equals(JsonToken.END_ARRAY)) {
				reader.endArray();
				break;
			} else if (token.equals(JsonToken.BEGIN_OBJECT)) {
				handleJsonObject(reader);
			} else if (token.equals(JsonToken.END_OBJECT)) {
				reader.endObject();
			} else {
				System.out.println(reader.nextInt() + " ");
			}
		}
	}

}
