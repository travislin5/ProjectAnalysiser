package com.example.ProjectAnalysiser.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetFlieString {

	public static void main(String[] args) {
//		getFileString(
//				"/Users/travislin/Documents/workspace-spring-tool-suite-4-4.11.1.RELEASE/TestZZZZ/src/test/FindFiles.java");

	}

	public static String getFileString(String filePath) {

		String all = getAllString(filePath);

//		String afterReplace = replaceEmpty(all);

		return all;
	}

	private static String getAllString(String filePath) {
		String all = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			StringBuilder fileContent = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				fileContent.append(line);
				fileContent.append(System.lineSeparator()); // 加入換行符
			}
			all = fileContent.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all;
	}

	private static String replaceEmpty(String allFileString) {

//		System.out.println(allFileString);

		String output = allFileString.replaceAll("\\s", "");

		return output;
	}

}
