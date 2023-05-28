package com.example.ProjectAnalysiser.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassNameFile {

	public static void main(String[] args) {

//		addClassNameToFile("/Users/travislin/Documents/GitHub/accounting");

		getClassNameList("/Users/travislin/Downloads/zzzzzzzzzzz/AllClassName.txt");

	}

	public static void addClassNameToFile(String directoryPath) {

//		名稱存在清單
		List<String> allDirStrings = FindFiles.getFileList(directoryPath);

//		把不需要的剪掉
		List<String> afterCut = cutNoNeed(allDirStrings);

//		存到
		CreateFiles.createFile(afterCut, "/Users/travislin/Downloads/zzzzzzzzzzz/AllClassName.txt");

	}

	public static List<String> getClassNameList(String directoryPath) {

		String filePath = directoryPath;
		List<String> lines = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return lines;
	}

	private static List<String> cutNoNeed(List<String> allDirStrings) {

		List<String> afterCut = new ArrayList<>();

		for (String string : allDirStrings) {
//			System.out.println(string);
			String cut = GetBetween.getWordBetween(string, "/", ".java");

			if (!cut.isBlank()) {
				afterCut.add(cut);
			}
		}

		return afterCut;
	}

}
