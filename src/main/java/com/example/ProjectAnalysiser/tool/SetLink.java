package com.example.ProjectAnalysiser.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetLink {

	public static void main(String[] args) {
//		  Map<String, List<Map<String, Integer>>> data = new HashMap<>();
//
//	        // 創建內部的 Map
//	        Map<String, Integer> innerMap = new HashMap<>();
//	        innerMap.put("b", 123);
//
//	        // 創建外部的 List
//	        List<Map<String, Integer>> outerList = new ArrayList<>();
//	        outerList.add(innerMap);
//	        outerList.add(innerMap);
//
//	        // 將外部 List 放入外部 Map
//	        data.put("a", outerList);
//
//	        // 使用結構中的值
//	        List<Map<String, Integer>> retrievedList = data.get("a");
//	        Map<String, Integer> retrievedInnerMap = retrievedList.get(0);
//	        Integer value = retrievedInnerMap.get("b");
//
//	        System.out.println(data.toString()); // 輸出 123
		
		createDaoLink();
	}
	
	
	public static void createDaoLink() {
		
		  Map<String, List<String>> data = new HashMap<>();
		  
		  List<String> linkTables = new ArrayList<>();
		 
		  linkTables.add("aTable");
		  linkTables.add("bTable");

		  data.put("xxDao", linkTables);
		  data.put("iiDao", linkTables);
		  
		  System.out.println(data);
		
	}

}
