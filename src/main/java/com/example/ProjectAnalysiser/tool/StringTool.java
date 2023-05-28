package com.example.ProjectAnalysiser.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTool {

	public static void main(String[] args) {

	}

	public static boolean preAndNextNotEng(String fileString, String checkString) {

		// 刪除非自己寫的套件
		String removed = removeJavaxImport(fileString);

		// 判斷前面不能為英文、數字、＠，後面不能是英文、數字
		String regex = "(?<![a-zA-Z0-9@])" + Pattern.quote(checkString) + "(?![a-zA-Z0-9])";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(removed);
		return matcher.find();

	}

	private static String removeJavaxImport(String input) {
		String removed = input.replaceAll("javax.*?;", "");
		return removed;
	}

}
