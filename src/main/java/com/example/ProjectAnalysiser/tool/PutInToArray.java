package com.example.ProjectAnalysiser.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PutInToArray {

	public static void main(String[] args) {
		  Map<String, List<Map<String, Integer>>> data = new HashMap<>();
	        Map<String, Integer> innerMap = new HashMap<>();
	        innerMap.put("b", 123);
	        List<Map<String, Integer>> outerList = new ArrayList<>();
	        outerList.add(innerMap);
	        data.put("a", outerList);
	        

	        // 將對象轉換為 JSON 字串
	        Gson gson = new Gson();
	        String json = gson.toJson(data);

	        // 輸出 JSON 字串
	        System.out.println(json);
			List<String> lines = new ArrayList<>();
			lines.add(json);
			CreateFiles.createFile(lines, "/Users/travislin/Downloads/zzzzzzzzzzz/test.txt");
	        
	        
	        Map<String, List<Map<String, Integer>>> object = gson.fromJson(json,new TypeToken<Map<String, List<Map<String, Integer>>>>(){}.getType());
	        
	        System.out.println(object.get("a").get(0).get("b"));
	        
	}

}
