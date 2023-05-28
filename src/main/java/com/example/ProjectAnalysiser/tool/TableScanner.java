package com.example.ProjectAnalysiser.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableScanner {

	public static void main(String[] args) {
		String query = "Select * from Menu M, Foodtype F Where M.TypeID = F.TypeID;";

		String regex = "(?i)FROM\\s+([\\w.]+)";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(query);

		while (matcher.find()) {
			String table = matcher.group(1);
			System.out.println("Found table: " + table);
		}
	}

}
