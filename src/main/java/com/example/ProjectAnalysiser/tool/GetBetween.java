package com.example.ProjectAnalysiser.tool;

public class GetBetween {

	public static void main(String[] args) {

		System.out.println(getWordBetween("abaer/tfrewjioj/87123.java", "/", ".java"));
	}

	public static String getWordBetween(String who, String from, String to) {

		String input = who;
		String startSymbol = from;
		String endSymbol = to;
		String extractedText;

		int startIndex = input.lastIndexOf(startSymbol);
		int endIndex = input.indexOf(endSymbol);

		if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
			extractedText = input.substring(startIndex + 1, endIndex);
//	            System.out.println("中間的文字為：" + extractedText);
		} else {
//	            System.out.println("找不到符合的文字。");
			extractedText = "";
		}

		return extractedText;
	}

	public static String getAfterLastSlash(String input) {
		String result = "";
		int lastIndex = input.lastIndexOf("/");
		if (lastIndex != -1) {
			String cut = input.substring(lastIndex + 1);
			result = cut;
		}

		return result;
	}

}
