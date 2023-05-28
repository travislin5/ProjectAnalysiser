package com.example.ProjectAnalysiser.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListTool {

	public static void main(String[] args) {

	}

	public static List<String> listDiff(List<String> list1, List<String> list2) {

		// 使用 Stream API 比較兩個 List，組成不相同的字串陣列
		List<String> diffStrings = list1.stream().filter(str -> !list2.contains(str)).toList();

		return diffStrings;
	}

	public static List<String> listAndSetDiff(List<String> list, Set<String> set) {

		// 將 List 和 Set 的不相同元素組成一個陣列
		List<String> diffElements = new ArrayList<>(list);
		diffElements.removeAll(set);

		return diffElements;
	}

}
