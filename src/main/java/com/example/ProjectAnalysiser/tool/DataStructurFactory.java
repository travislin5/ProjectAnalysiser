package com.example.ProjectAnalysiser.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class DataStructurFactory {

	public static void main(String[] args) {

		System.out.println(eachRootStruc("CRUDOrderDetailsController"));

		Gson gson = new Gson();
		String json = gson.toJson(eachRootStruc("CRUDOrderDetailsController"));

		System.out.println(json);
	}

	public static Map<String, Object> eachRootStruc(String root) {

		Map<String, Object> dataMap = new HashMap<>();

		// 取得root的所有資料
		List<String> data = ContainTree.findDataByName(root);

		// 遍歷所有資料看看哪些是找的到的檔案
		if (data.size() != 0) {
			for (String string : data) {
				if (ContainTree.dataFileExists(string)) {
					dataMap.put(string, eachRootStruc(string));
				} else {
					dataMap.put(string, "無");
				}
			}
		}

		// 如果有的話？如果沒有的話？

		return dataMap;
	}
	
	public static String eachRootStrucJson(String root) {

		Map<String, Object> dataMap = new HashMap<>();

		// 取得root的所有資料
		List<String> data = ContainTree.findDataByName(root);

		// 遍歷所有資料看看哪些是找的到的檔案
		if (data.size() != 0) {
			for (String string : data) {
				if (ContainTree.dataFileExists(string)) {
					dataMap.put(string, eachRootStruc(string));
				} else {
					dataMap.put(string, "無");
				}
			}
		}
		
		Gson gson = new Gson();
		String dataMapJson = gson.toJson(dataMap);
		
		
		return dataMapJson;
	}

}
