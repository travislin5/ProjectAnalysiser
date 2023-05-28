package com.example.ProjectAnalysiser.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBlank {

	public static void main(String[] args) {
		  String input = "Hello @World@, this is a test. @Hello@ World!";

	        // 正規表示式
	        String regex = "(?<![a-zA-Z])@?[a-zA-Z]+@?(?![a-zA-Z])";

	        // 創建 Pattern 物件
	        Pattern pattern = Pattern.compile(regex);

	        // 創建 Matcher 物件
	        Matcher matcher = pattern.matcher(input);

	        // 遍歷匹配結果
	        while (matcher.find()) {
	            String match = matcher.group();
	            System.out.println(match);
	        }
	}

	public static void testBlank() {
		String text = "Hello World";
		String pattern = "^\\s+|\\s+$";

		// 建立正則表達式的模式
		Pattern regexPattern = Pattern.compile(pattern);

		// 建立文字的匹配器
		Matcher matcher = regexPattern.matcher(text);

		// 判斷指定文字前後是否為空白
		if (matcher.find()) {
			System.out.println("指定文字前後有空白");
		} else {
			System.out.println("指定文字前後都不是空白");
		}
	}

	public static void getIndex() {
		String str = "Hello, World!";
		String substr = "Hello";

		int startIndex = str.indexOf(substr);
		int endIndex = startIndex + substr.length() - 1;

		System.out.println("起始位置索引：" + startIndex);
		System.out.println("結尾位置索引：" + endIndex);

		System.out.println(str.charAt(startIndex - 1));
		System.out.println(str.charAt(endIndex + 1));

	}

	public static void getIndex2() {
		String text = "Hello, world! world";
		String substring = "world";

		int index = text.indexOf(substring);

		if (index != -1) {
			System.out.println("找到子字串，位置為：" + index);
			System.out.println(text.charAt(index));
		} else {
			System.out.println("未找到子字串");
		}

	}

}
