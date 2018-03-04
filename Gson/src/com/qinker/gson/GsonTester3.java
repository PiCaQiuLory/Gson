package com.qinker.gson;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
/**
 * 
 * Copyright (c)   2018 by lory
 * @ClassName:     GsonTester3.java
 * @Description:   JsonParser可以将json串转为树模型准备JSON文档的内存树表示。
 *  它构建了一个JsonObject节点树。 这是一种灵活的方法，类似于XML的DOM解析器。在读取JSON之后，JsonParser提供了一个指向树的根节点的指针。
 *  根节点可以用来遍历整个树。 考虑下面的代码片段来获取提供的JSON字符串的根节点。
 * 
 * @author:        lory
 * @version:       V1.0  
 * @Date:          2018年3月4日 上午11:51:45
 */
public class GsonTester3 {

	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Maxsu\", \"age\":26,\"verified\":false,\"marks\": [100,90,85]}";

		JsonParser parser = new JsonParser();
		JsonElement rootNode = parser.parse(jsonString);
		
		//判断节点是否是jsonObject对象
		if (rootNode.isJsonObject()) {
			JsonObject details = rootNode.getAsJsonObject();
			JsonElement nameNode = details.get("name");
			System.out.println("Name: " + nameNode.getAsString());

			JsonElement ageNode = details.get("age");
			System.out.println("Age: " + ageNode.getAsInt());

			JsonElement verifiedNode = details.get("verified");
			System.out.println("Verified: " + (verifiedNode.getAsBoolean() ? "Yes" : "No"));

			JsonArray marks = details.getAsJsonArray("marks");
			for (int i = 0; i < marks.size(); i++) {
				JsonPrimitive rPrimitive = marks.get(i).getAsJsonPrimitive();
				System.out.print(rPrimitive.getAsInt() + " ");
			}
		}
	}
}
